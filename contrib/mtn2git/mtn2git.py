#!/usr/bin/env python

"""
  Copyright (C) 2006, 2007, 2008 Holger Hans Peter Freyther

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

import mtn
import os
import sys
import datetime
import email.Utils

import status

# Interesting revisions:
# Rename with dest==src: 24cba5923360fef7c5cc81d51000e30b90355eb9
# Recursive rename: fca159c5c00ae4158c289f5aabce995378d4e41b
# Delete+Rename: 91da98265a39c93946e00adf5d7bf92b341de847
#
#
#

# Our manifest/tree fifo construct
cached_tree = {}
cached_fifo = []

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
    status.mark_file.flush()
    return status.last_mark

def has_mark(revision):
    return revision in status.marks

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
        branch = "mtn-rev-%s" % revision["revision"]
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

def checkpoint():
    """
    Force git to checkpoint the import
    """
    cmd = [] 
    cmd += ["checkpoint"]
    cmd += [""]
    print "\n".join(cmd)
    
def get_git_date(revision):
    """
    Convert the "date" cert of monotone to a time understandable by git. No timezone
    conversions are done.
    """
    dt = datetime.datetime.strptime(revision["date"], "%Y-%m-%dT%H:%M:%S").strftime("%a, %d %b %Y %H:%M:%S +0000")
    return dt

def is_executable_attribute_set(attributes, rev):
    assert(len(attributes) % 3 == 0), rev

    if len(attributes) >= 3:
        for i in range(0, len(attributes)%3+1):
            if attributes[i] == "attr" and attributes[i+1] == "mtn:execute" and attributes[i+2] == "true":
                return True
    return False

def build_tree(manifest, rev):
    """Assemble a filesystem tree from a given manifest"""

    class tree:
        def __init__(self):
            self.dirs = {}
            self.files= {}

    tree = tree()
    for line in manifest:
        if line[0] == "file":
            tree.files[line[1]] = (line[3], is_executable_attribute_set(line[4:], rev))
        elif line[0] == "dir":
            tree.dirs[line[1]] = 1
        elif line[0] != "format_version":
            assert(False), "Rev: %s: Line[0]: '%s'" % (rev, line[0])

    return tree

def get_and_cache_tree(ops, revision):
    """Simple FIFO to cache a number of trees"""
    global cached_tree, cached_fifo

    if revision in cached_tree:
        return cached_tree[revision]

    tree = build_tree([line for line in ops.get_manifest_of(revision)], revision)
    cached_tree[revision] = tree
    cached_fifo.append(revision)

    # Shrink
    if len(cached_fifo) > 100:
        old_name = cached_fifo[0]
        cached_fifo = cached_fifo[1:]
        del cached_tree[old_name]

    return tree
    
def diff_manifest(old_tree, new_tree):
    """Find additions, modifications and deletions"""
    added = set()
    modified = set()
    deleted = set()

    # Removed dirs
    for dir in old_tree.dirs.keys():
        if not dir in new_tree.dirs:
            deleted.add((dir,True))

    # New dirs
    for dir in new_tree.dirs.keys():
        if not dir in old_tree.dirs:
            added.add(dir)

    # Deleted files
    for file in old_tree.files.keys():
        if not file in new_tree.files:
            deleted.add((file,False))

    # Added files, goes to modifications
    for file in new_tree.files.keys():
        if not file in old_tree.files:
            modified.add((file, new_tree.files[file][0]))
            continue

        # The file changed, either contents or executable attribute
        old = old_tree.files[file]
        new = new_tree.files[file]
        if old != new:
            modified.add((file, new_tree.files[file][0]))
            
    return (added, modified, deleted)

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

    # Use the manifest to find dirs and files
    current_tree = get_and_cache_tree(ops, revision["revision"])

    # Now diff the manifests
    if len(revision["parent"]) == 0:
        merge_from = None
        merge_other = []
        (added, modified, deleted) = diff_manifest(build_tree([],""), current_tree)
    else:
        # The first parent is our from.
        merge_from = revision["parent"][0]
        merge_other = revision["parent"][1:]
        (added, modified, deleted) = diff_manifest(get_and_cache_tree(ops, merge_from), current_tree)

    # TODO:
    # Readd the sanity check to see if we deleted and modified an entry. This
    # could probably happen if we have more than one parent (on a merge)?

    cmd = []
    if len(revision["parent"]) == 0:
        cmd += ["reset refs/heads/%s" % branch]
    cmd += ["commit refs/heads/%s" % branch]
    cmd += ["mark :%s" % get_mark(revision["revision"])]
    cmd += ["author  <%s> %s" % (revision["author"], get_git_date(revision))]
    cmd += ["committer  <%s> %s" % (revision["committer"], get_git_date(revision))]
    cmd += ["data  %d" % len(revision["changelog"])]
    cmd += ["%s" % revision["changelog"]]

    if not merge_from is None:
        cmd += ["from :%s" % get_mark(merge_from)]

    for parent in merge_other:
        cmd += ["merge :%s" % get_mark(parent)]

    for dir_name in added:
        cmd += ["M 644 inline %s" % os.path.join(dir_name, ".mtn2git_empty")]
        cmd += ["data <<EOF"]
        cmd += ["EOF"]
        cmd += [""]

    for (file_name, file_revision) in modified:
        (mode, file) = get_file_and_mode(ops, current_tree, file_name, file_revision, revision["revision"])
        cmd += ["M %d inline %s" % (mode, file_name)]
        cmd += ["data %d" % len(file)]
        cmd += ["%s" % file]

    for (path, is_dir) in deleted:
        if is_dir:
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

def get_file_and_mode(operations, file_tree, file_name, _file_revision, rev = None):
    assert file_name in file_tree.files, "get_file_and_mode: Revision '%s', file_name='%s' " % (rev, file_name)

    (file_revision, executable) = file_tree.files[file_name]
    if _file_revision:
        assert _file_revision == file_revision, "Same filerevision for file_name='%s' in rev='%s' (%s,%s)" % (file_name, rev, file_revision, _file_revision)

    if executable:
        mode = 755
    else:
        mode = 644

    file = "".join([file for file in operations.get_file(file_revision)])
    return (mode, file)

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
        elif line[0] == "clear":
            revision_description["clear_attributes"].append((line[1], line[3], old_rev))
        elif line[0] == "set":
            revision_description["set_attributes"].append((line[1], line[3], line[5], old_rev))
        elif line[0] in ["rename", "patch", "delete", "add_dir", "add_file"]:
            pass
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
            #assert(False)

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
    branch_heads = {}
    for branch in branches:
        heads = [head for head in ops.heads(branch)]
        if len(heads) != 1:
            print >> sys.stderr, "Skipping branch '%s' due multiple heads" % (branch)
            continue

        if branch in status.former_heads:
            old_heads = status.former_heads[branch]
        else:
            old_heads = []

        for head in heads:
            print >> sys.stderr, old_heads, head
            all_revs += ops.ancestry_difference(head, old_heads)
        status.former_heads[branch] = heads

    counter = 0
    sorted_revs = [rev for rev in ops.toposort(all_revs)]
    for rev in sorted_revs:
        if has_mark(rev):
            print >> sys.stderr, "B: Already having commit '%s'" % rev
        else:
            print >> sys.stderr, "Going to import revision ", rev
            fast_import(ops, parse_revision(ops, rev))
            if counter % 1000 == 0:
                checkpoint()
            counter += 1

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

