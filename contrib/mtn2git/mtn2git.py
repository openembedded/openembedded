#!/usr/bin/env python

"""
  Copyright (C) 2006, 2007 Holger Hans Peter Freyther

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
"""

####
# TODO:
#   -tag handling
#   -work with n-merges
#
# DISCUSSION:
#   -For some reason the get_revision information might be inaccurate
#    and I should consider just comparing the manifests.
#    I would use the manifests of the parents and consider all files deleted
#    and then remove every dir/file that is inside the new manifest from this
#    list.
#      Benefits:
#         - 1:1 match of the manifest regardles of get_revision information
#         - Renaming is handled by git anyway
#      Downsides:
#         - The size of the import will grow.
#

import mtn
import os
import sys
import datetime
import email.Utils

import status


def get_mark(revision):
    """
    Get a mark for a specific revision. If the revision is known the former
    mark will be returned. Otherwise a new mark will be allocated and stored
    to the mark file.
    """
    if revision in status.marks:
        return status.marks[revision]
    status.last_mark += 1
    status.marks[revision] = status.last_mark
    print >> status.mark_file, "%d: %s" % (status.last_mark, revision)
    return status.last_mark

def has_mark(revision):
    return revision in status.marks


def mark_empty_revision(revision, parent):
    """Git does not like empty merges, just skip the revision"""
    # TODO, FIXME, XXX, We might want to add a reset cmd here
    print >> sys.stderr, "Found an empty revision, skipping '%s'" % revision
    parent_mark = status.marks[parent]
    status.marks[revision] = parent_mark

    # There is another mtn revision that is using this mark!
    if not parent_mark in status.same_revisions:
        status.same_revisions[parent_mark] = []
    status.same_revisions[parent_mark].append(revision)


def get_branch_name(revision):
    """
    TODO for unnamed branches (e.g. as we lack the certs) we might want to follow
    the parents until we end up at a item with a branch name and then use the last
    item without a name...
    """
    if "branch" in revision:
        branch = revision["branch"]
    else:
        #branch = "initial-%s" % revision["revision"]
        branch = "mtn-unnamed-branch"
    return branch

def reset_git(ops, revision):
    """
    Find the name of the branch of this revision
    """
    branch = get_branch_name(revision)

    cmd = []
    cmd += ["reset refs/heads/%s" % branch]
    cmd += ["from :%s" % get_mark(revision["revision"])]
    cmd += [""]
    print "\n".join(cmd)

def filter_renamed(manifest, renamed):
    """
    If we base from a revision that has already done
    the move, git-fast-import will complain that the file
    has been already moved
    """
    if len(renamed) == 0:
        return renamed

    for line in manifest:
        if line[0] == "file":
            renamed = filter(lambda (to,from_,manifest): to != line[1], renamed)
            
    return renamed

def get_git_date(revision):
    """
    Convert the "date" cert of monotone to a time understandable by git. No timezone
    conversions are done.
    """
    dt = datetime.datetime.strptime(revision["date"], "%Y-%m-%dT%H:%M:%S").strftime("%a, %d %b %Y %H:%M:%S +0000")
    return dt

def recursively_delete(ops, manifest, revision, dir_name, to_delete):
    """
    Recursively delete all files that dir_name inside the name
    """
    for line in manifest:
        if line[0] == "dir" or line[0] == "file":
            if line[1].startswith(dir_name):
                print >> sys.stderr, "Deleting '%s'" % line[1]
                to_delete.add((line[1], revision))
        elif line[0] in ["format_version"]:
            assert(line[1] == "1")
        else:
            print >> sys.stderr, line[0]
            assert(False)

    return to_delete

def recursively_rename(ops, manifest, revision, old_name, new_name, to_add_dirs, to_add_files, to_remove_items, files_deleted, files_sticky):
    """
    mtn has a rename command and can rename entrie directories. For git we will have to do the recursive renaming
    ourselves. Basicly we will get all files and replace old_name with new_name but only:

        If the file of the old_manifest is not in our to be deleted list
    """
    old_dir = old_name + "/"
    for line in manifest:
        if line[1].startswith(old_dir) or line[1] == old_name:
            already_handled = False
            for (deleted,_) in files_deleted:
                if line[1] == deleted:
                    already_handled = True
                    break 

            # Don't rename files that should be in the same directory
            if line[1] in files_sticky:
                already_handled = True

            if already_handled:
                pass
            elif line[0] == "file":
                print >> sys.stderr, "Will add '%s' old: '%s' new: '%s' => result: '%s'" % (line[1], old_name, new_name, line[1].replace(old_name, new_name, 1))
                to_add_files.add((line[1].replace(old_name, new_name, 1), None, revision))
            elif line[0] == "dir":
                to_add_dirs.add((line[1].replace(old_name, new_name, 1), revision))
            elif line[0] in ["format_version"]:
                assert(line[1] == "1")
            else:
                print >> sys.stderr, line[0]
                assert(False)

    return (to_add_files, to_add_dirs)

#
#    We need to recursively rename the directories. Now the difficult part is to undo certain operations.
#    
#    e.g we rename the whole dir and then rename a file back. We could revive a directory that was marked
#    for deletion.
#
#    rename "weird/two/three"
#    to "unweird/four"
#
#    rename "weird/two/three/four"
#    to "weird/two/three"
#
#    Here we would schedule weird/two/three for deletion but then revive it again. So three does not
#    get copied to unweird/four/three
#    """
def recursively_rename_directories(ops, manifests, rename_commands, files_deleted, files_moved_sticky):
    to_add_directories = set()
    to_add_files = set()
    to_remove_items = set()

    for (old_name, new_name, old_revision) in rename_commands:
        # Check if we have the above case and rename a more specific directory
        # and then we will alter the result...
        inner_rename = False
        for (other_old_name, other_new_name, other_rev) in rename_commands:
            if old_name.startswith(other_old_name + "/") and other_old_name != old_name:
                inner_rename = True
                print >> sys.stderr, "Inner rename detected", old_name, other_old_name
                # Fixup the renaming
                def rename(filename, filerev, rev, would_be_new_name):
                    if filename.startswith(would_be_new_name + "/"):
                        return filename.replace(would_be_new_name, new_name, 1), filerev, rev
                    return filename, filerev, rev
                    
                would_be_new_name = other_new_name + "/" + old_name[len(other_old_name)+1:]
                to_remove_items = set(filter(lambda (item,_): item != new_name, to_remove_items))
                to_add_directories = set(filter(lambda (item,_): item != would_be_new_name, to_add_directories))
                to_add_directories.add((new_name, old_revision))
                to_add_files = set(map(lambda (fn, fr, r): rename(fn, fr, r, would_be_new_name), to_add_files))

        if not inner_rename:
            to_remove_items.add((old_name, old_revision))
            recursively_delete(ops, manifests[old_revision], old_revision, old_name + "/", to_remove_items)
            recursively_rename(ops, manifests[old_revision], old_revision, old_name, new_name, to_add_directories, to_add_files, to_remove_items, files_deleted, files_moved_sticky)

    return (to_add_directories, to_add_files, to_remove_items)


def build_tree(manifest):
    dirs = {}
    files = {}
    for line in manifest:
        if line[0] == "file":
            files[line[1]] = (line[3],line[4:])
        elif line[0] == "dir":
            dirs[line[1]] = 1
        elif line[0] != "format_version":
            print >> sys.stderr, line[0]
            assert(False)
    return (dirs,files)

def compare_with_manifest(all_added, all_modified, all_deleted, new_manifest, old_manifests):
    """
    Sanity check that the difference between the old and the new manifest is the one
    we have in all_added, all_modified, all_deleted
    """
    old_trees = {}
    really_added = {}
    really_modified = {}
    really_removed = {}

    current_dirs, current_files = build_tree(new_manifest)

    for parent in old_manifests.keys():
        old_trees[parent] = build_tree(old_manifests[parent])

    print >> sys.stderr, len(old_manifests)

def fast_import(ops, revision):
    """Import a revision into git using git-fast-import.

    First convert the revision to something git-fast-import
    can understand
    """
    assert("revision" in revision)
    assert("author" in revision)
    assert("committer" in revision)
    assert("parent" in revision)


    branch = get_branch_name(revision)

    # Okay: We sometimes have merged where the old manifest is the new one
    # I have no idea how this can happen but there are at least two examples in the
    # net.venge.monotone history.
    # The problem ist git-fast-import will not let us create the same manifest again.
    # So if we are in a merge, propagation and the old manifest is the new one we will
    # do a git-reset.
    # Examples in the mtn history: 6dc36d2cba722f500c06f33e225367461059d90e, dc661f0c25ee96a5a5cf5b5b60deafdf8ccaf286
    # and 7b8331681bf77cd8329662dbffed0311765e7547, 13b1a1e617a362c5735002937fead98d788737f7
    # aa05aa9171bac92766b769bbb703287f53e08693 is a merge of the same manifest...
    # so we will just go with one of the two revisions..
    # We will have the same manifest if we propagate something from one branch to another. git does
    # not have a special revision showing that copy but will only change the head.
    # We will do the same and reset the branch to this revision.
    for parent in revision["parent"]:
        manifest_version = parse_revision(ops, parent)["manifest"]
        if manifest_version == revision["manifest"]:
            mark_empty_revision(revision["revision"], parent)
            reset_git(ops, revision)
            return
        
    # Use the manifest to find dirs and files
    manifest = [line for line in ops.get_manifest_of(revision["revision"])]
    manifests = {}
    dirs = {}
    for parent in revision["parent"]:
        manifests[parent] = [line for line in ops.get_manifest_of(parent)]
        for line in manifests[parent]:
            if line[0] == "dir":
                if not parent in dirs:
                    dirs[parent] = {}
                dirs[parent][line[1]] = 1

    # We can not just change the mode of a file but we need to modifiy the whole file. We
    # will simply add it to the modified list and ask to retrieve the status from the manifest
    for (file, attribute, value, rev) in revision["set_attributes"]:
        if attribute == "mtn:execute":
            revision["modified"].append((file, None, rev))
    for (file, attribute, rev) in revision["clear_attributes"]:
        if attribute == "mtn:execute":
            revision["modified"].append((file, None, rev))



    cmd = []
    cmd += ["commit refs/heads/%s" % branch]
    cmd += ["mark :%s" % get_mark(revision["revision"])]
    cmd += ["author  <%s> %s" % (revision["author"], get_git_date(revision))]
    cmd += ["committer  <%s> %s" % (revision["committer"], get_git_date(revision))]
    cmd += ["data  %d" % len(revision["changelog"])]
    cmd += ["%s" % revision["changelog"]]

    # Emulation for renaming. We will split them into two lists
    file_renamed_del = set()
    file_renamed_new = set()
    file_moved_sticky = set()

    if len(revision["parent"]) != 0:
        cmd += ["from :%s" % get_mark(revision["parent"][0])]
    renamed = revision["renamed"]

    to_rename_directories = []
    for (new_name, old_name, old_revision) in renamed:
        # 24cba5923360fef7c5cc81d51000e30b90355eb9 is a rev where src == dest but the
        # directory got renamed, so this means this file got added to the new directory
        # TODO, XXX, FIXME check if this can be done for directories as well
        if new_name == old_name and not old_name in dirs[old_revision]:
            print >> sys.stderr, "Bogus rename in %s (%s, %s)?" % (revision["revision"], new_name, old_name)
            file_moved_sticky.add(old_name)

        # Check if the old_name was a directory in the old manifest
        # If we rename a directory we will need to recursively remove and recursively
        # add...
        # Add the '/' otherwise we might rename the wrong directory which shares the
        # same prefix.
        # fca159c5c00ae4158c289f5aabce995378d4e41b is quite funny. It renames a directory
        # and then renames another directory within the renamed one and in the worse case
        # we will revive a deleted directory, file...
        elif old_name in dirs[old_revision]:
            print >> sys.stderr, "Detected directory rename '%s' => '%s'" %  (old_name, new_name)
            assert(old_revision in manifests)
            to_rename_directories.append((old_name, new_name, old_revision))
        else: 
            print >> sys.stderr, "Renaming %s => %s" % (old_name, new_name)
            file_renamed_new.add((new_name, None, revision["revision"]))
            file_renamed_del.add((old_name, old_revision))

    # The first parent is our from.
    for parent in revision["parent"][1:]:
        cmd += ["merge :%s" % get_mark(parent)]

    # Do the renaming now
    (renamed_dirs, renamed_new, renamed_old) = recursively_rename_directories(ops, manifests, to_rename_directories, file_renamed_del.union(set(revision["removed"])), file_moved_sticky)

    # Sanity check, don't remove anything we modify
    all_added = set(revision["added_dirs"]).union(renamed_dirs)
    all_modifications = set(revision["modified"]).union(set(revision["added_files"])).union(renamed_new).union(file_renamed_new)
    all_deleted = set(revision["removed"]).union(renamed_old).union(file_renamed_del)
    all_deleted_new = all_deleted

    # Check if we delete and add at the same time
    for (deleted,rev) in all_deleted:
        for (added,_) in all_added:
            if added == deleted:
                print >> sys.stderr, "Added and Deleted", added, deleted
                all_deleted_new = set(filter(lambda (dele,_): dele != added, all_deleted_new))
                assert((added,rev) not in all_deleted_new)
                
        for (modified,_,_) in all_modifications:
            if modified == deleted:
                print >> sys.stderr, "Modified and Deleted", modified, deleted
                all_deleted_new = set(filter(lambda (dele,_): dele != modified, all_deleted_new))
                assert((modified,rev) not in all_deleted_new)

    # Filtered list of to be deleted items
    all_deleted = all_deleted_new

    # Check if we delete but the manifest has a file like this
    for line in manifest:
        if line[0] == "dir" or line[0] == "file":
            for (deleted,rev) in all_deleted:
                if line[1] == deleted:
                    # 91da98265a39c93946e00adf5d7bf92b341de847 of mtn has a delete + rename
                    print >> sys.stderr, "Trying to delete a file which is in the new manifest", line[1], deleted
                    assert(False)

    compare_with_manifest(all_added, all_modifications, all_deleted, manifest, manifests)

    for (dir_name, rev) in all_added:
        cmd += ["M 644 inline %s" % os.path.join(dir_name, ".mtn2git_empty")]
        cmd += ["data <<EOF"]
        cmd += ["EOF"]
        cmd += [""]

    for (file_name, file_revision, rev) in all_modifications:
        (mode, file) = get_file_and_mode(ops, manifest, file_name, file_revision, revision["revision"])
        cmd += ["M %d inline %s" % (mode, file_name)]
        cmd += ["data %d" % len(file)]
        cmd += ["%s" % file]

    for (path, rev) in all_deleted:
        assert(rev in dirs)
        if path in dirs[rev]:
            cmd += ["D %s" % os.path.join(path, ".mtn2git_empty")]
        else:
            cmd += ["D %s" % path]

    cmd += [""]
    print "\n".join(cmd)


def is_trusted(operations, revision):
    for cert in operations.certs(revision):
        if cert[0] != 'key' or cert[3] != 'ok' or cert[8] != 'trust' or cert[9] != 'trusted':
            print >> sys.stderr, "Cert untrusted?, this must be bad", cert
            return False
    return True

def get_file_and_mode(operations, manifest, file_name, _file_revision, rev = None):
    mode = 644

    file_revision = None
    for line in manifest:
        if line[0] == "file" and line[1] == file_name:
            assert(line[1] == file_name)
            assert(line[2] == "content")
            
            if _file_revision:
                assert(line[3] == _file_revision)
            file_revision = line[3]

            attributes = line[4:]
            assert(len(attributes) % 3 == 0)
            if len(attributes) >= 3:
                for i in range(0, len(attributes)%3+1):
                    if attributes[i] == "attr" and attributes[i+1] == "mtn:execute" and attributes[i+2] == "true":
                        mode = 755
                        break

            assert(file_revision)
            file = "".join([file for file in operations.get_file(file_revision)])
            return (mode, file)

    print >> sys.stderr, file_name, rev
    assert(False)


def parse_revision(operations, revision):
    """
    Parse a revision as of mtn automate get_revision

    Return a tuple with the current version, a list of parents,
    a list of operations and their revision
    """ 
    if not is_trusted(operations, revision):
        raise Exception("Revision %s is not trusted!" % revision)

    # The order of certain operations, e.g rename matter so don't use a set
    revision_description = {}
    revision_description["revision"] = revision
    revision_description["added_dirs"] = []
    revision_description["added_files"] = []
    revision_description["removed"] = []
    revision_description["modified"] = []
    revision_description["renamed"] = []
    revision_description["set_attributes"] = []
    revision_description["clear_attributes"] = []

    old_rev = None

    for line in operations.get_revision(revision):
        if line[0] == "format_version":
            assert(line[1] == "1")
        elif line[0] == "old_revision":
            if not "parent" in revision_description:
                revision_description["parent"] = []
            if len(line[1]) != 0:
                revision_description["parent"].append(line[1])
            old_rev = line[1]
        elif line[0] == "new_manifest":
            revision_description["manifest"] = line[1]
        elif line[0] == "rename":
            revision_description["renamed"].append((line[3], line[1], old_rev))
        elif line[0] == "patch":
            revision_description["modified"].append((line[1], line[5], old_rev))
        elif line[0] == "delete":
            revision_description["removed"].append((line[1], old_rev))
        elif line[0] == "add_dir":
            revision_description["added_dirs"].append((line[1], old_rev))
        elif line[0] == "add_file":
            revision_description["added_files"].append((line[1], line[3], old_rev))
        elif line[0] == "clear":
            revision_description["clear_attributes"].append((line[1], line[3], old_rev))
        elif line[0] == "set":
            revision_description["set_attributes"].append((line[1], line[3], line[5], old_rev))
        else:
            print >> sys.stderr, line
            assert(False)

    for cert in operations.certs(revision):
        # Known cert names used by mtn, we can ignore them as they can't be converted to git
        if cert[5] in ["suspend", "testresult", "file-comment", "comment", "release-candidate"]:
            pass
        elif cert[5] in ["author", "changelog", "date", "branch", "tag"]:
            revision_description[cert[5]] = cert[7]
            if cert[5] == "author":
                revision_description["committer"] = cert[1]
        else:
            print >> sys.stderr, "Unknown Cert: Ignoring", cert[5], cert[7]
            assert(False)

    return revision_description
                

def tests(ops, revs):
    """Load a bunch of revisions and exit"""
    for rev in revs:
        print >> sys.stderr, rev
        fast_import(ops, parse_revision(ops, rev))

    sys.exit()

def main(mtn_cli, db, rev):
    if not db:
        print >> sys.stderr, "You need to specifiy a monotone db"
        sys.exit()

    ops = mtn.Operations([mtn_cli, db])

    # Double rename in mtn
    #tests(ops, ["fca159c5c00ae4158c289f5aabce995378d4e41b"])

    # Rename and remove in OE
    #tests(ops, ["74db43a4ad2bccd5f2fd59339e4ece0092f8dcb0"])

    # Rename + Dele
    #tests(ops, ["91da98265a39c93946e00adf5d7bf92b341de847"])

    # Issue with renaming in OE
    #tests(ops, ["c81294b86c62ee21791776732f72f4646f402445"])

    # Unterminated inner renames
    #tests(ops, ["d813a779ef7157f88dade0b8ccef32f28ff34a6e", "4d027b6bcd69e7eb5b64b2e720c9953d5378d845", "af5ffd789f2852e635aa4af88b56a893b7a83a79"])

    # Broken rename in OE. double replacing of the directory command
    #tests(ops, ["11f85aab185581dcbff7dce29e44f7c1f0572a27"])

    if rev:
        tests(ops, [rev])
        sys.exit()

    branches = [branch.name for branch in ops.branches()]
    ops.automate.stop()

    all_revs = []
    for branch in branches:
        heads = [head for head in ops.heads(branch)]
        if branch in status.former_heads:
            old_heads = status.former_heads[branch]
        else:
            old_heads = []

        for head in heads:
            all_revs += ops.ancestry_difference(head, old_heads)
        status.former_heads[branch] = heads
    
    sorted_revs = [rev for rev in ops.toposort(all_revs)]
    for rev in sorted_revs:
        if has_mark(rev):
            print >> sys.stderr, "Already having commit '%s'" % rev
        else:
            print >> sys.stderr, "Going to import revision ", rev
            fast_import(ops, parse_revision(ops, rev))
        

if __name__ == "__main__":
    import optparse
    parser = optparse.OptionParser()
    parser.add_option("-d", "--db", dest="database",
                      help="The monotone database to use")
    parser.add_option("-m", "--marks", dest="marks", default="mtn2git-marks",
                      help="The marks allocated by the mtn2git command")
    parser.add_option("-t", "--mtn", dest="mtn", default="mtn",
                      help="The name of the mtn command to use")
    parser.add_option("-s", "--status", dest="status", default="mtn2git.status.v2",
                      help="The status file as used by %prog")
    parser.add_option("-r", "--revision", dest="rev", default=None,
                      help="Import a single revision to help debugging.")

    (options,_) = parser.parse_args(sys.argv)
    status.mark_file = file(options.marks, "a")

    try:
        status.load(options.status)
    except IOError:
        print >> sys.stderr, "Failed to open the status file"
    main(options.mtn, options.database, options.rev)
    status.store(options.status)
