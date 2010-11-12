# Copyright (c) 2009 MontaVista Software, Inc.  All rights reserved.
#
# Released under the MIT license (see LICENSE.MIT for the terms)
#
# For a given provider, populate the recipe and associated files for it and its
# dependencies into a new collection from your existing ones.  Great for extracting
# just the recipes you need from OpenEmbedded to do your work with a faster parse
# time.


# Ensure that newcollection is run on the dependencies pulled in by specific
# tasks (i.e. do_package_rpm[depends] = "rpm-native:do_populate_staging").
def __newcollection_setup_taskdeps(d):
    deps = []
    for task in (key for key in d.keys() if d.getVarFlag(key, "task")):
        taskdeps = d.getVarFlag(task, "depends")
        if taskdeps:
            items = (entry.split(":") for entry in taskdeps.split() if entry)
            items = (entry for entry in items if len(entry) > 1)
            deps.extend(("%s:do_newcollection" % dep for (dep, deptask) in items))

    d.setVarFlag("do_newcollection_all", "depends", " ".join(deps))

def __newcollection_get_recipe(d):
    from os.path import isabs
    from bb import which

    recipe = d.getVar("FILE", 1)
    if not isabs(recipe):
        return which(d.getVar("BBPATH", 1), recipe)
    else:
        return recipe

def __newcollection_get_recipedeps(d):
    depdata = d.getVar("__depends", 1)
    if not depdata:
        return []

    return [file for (file, rest) in depdata]

def __newcollection_get_fileuris(d):
    from urlparse import urlparse, urlunparse
    from glob import glob
    from os.path import isabs, join, exists

    files = []
    for uri in d.getVar("SRC_URI", 1).split():
        o = urlparse(uri)
        if o[0] != "file":
            continue

        (scheme, netloc, path, params, query, frag) = o

        if netloc:
            path = netloc + path

        try:
            spath = path.split(";")
            params = dict((part.split("=") for part in spath[1:]))
            path = spath[0]
        except ValueError:
            params = {}

        globbing = "*" in path
        filespath = reversed(d.getVar("FILESPATH", True).split(":"))
        for fp in filespath:
            newpath = join(fp, path)
            if globbing:
                globbed = filter(lambda f: exists(f), glob(newpath))
                files.extend(globbed)
            else:
                if exists(newpath):
                    files.append(newpath)

    return files

def __newcollection_populate_file(src, dest, d):
    import bb
    from os.path import dirname, isdir, exists
    from os import makedirs
    from errno import EEXIST
    from shutil import copytree, copy2

    if not exists(src):
        return

    bb.mkdirhier(dirname(dest))
    try:
        if isdir(src):
            copytree(src, dest, True)
        else:
            copy2(src, dest)
    except (OSError, IOError), e:
        bb.error("Unable to copy %s to %s:" % (src, dest))
        bb.error(str(e))
        return

    bb.note("Copied %s to %s." % (src, dest))


python do_newcollection() {
    from itertools import chain
    from os.path import join, normpath, sep, exists
    from glob import glob
    from bb import debug
    from bb.build import FuncFailed
    from urlparse import urlparse, urlunparse

    files = set([__newcollection_get_recipe(d)])
    files |= set(__newcollection_get_recipedeps(d))
    files |= set(__newcollection_get_fileuris(d))

    # filter out files that aren't in any overlays
    collectionsinfo = d.getVar("COLLECTIONSINFO",1) or ""
    if collectionsinfo:
        collections = list(chain(*(glob(normpath(collection['path']))
                                for collection in collectionsinfo.itervalues())))
    else:
        topdir = d.getVar("TOPDIR", True)
        collections = d.getVar("BBPATH", True).split(":")
        if topdir in collections:
            collections.remove(topdir)

    if not collections:
        return

    files = filter(lambda f: any(f.startswith(c) for c in collections), files)
    if not files:
        return

    destcol = d.getVar("NEWCOLLECTION", 1)
    if not destcol:
        raise FuncFailed("NEWCOLLECTION not defined, unable to populate new collection")

    existingcollections = (d.getVar("EXISTINGCOLLECTIONS", 1) or "").split() + [destcol]
    existing = []
    for path in existingcollections:
        pathurl = urlparse(path)
        if pathurl[0]:
                existing += [collection_fetch(path,pathurl,d)]
        else:
                existing += glob(normpath(path))

    for file in set(files):
        for col in collections:
            if file.startswith(col + sep):
                basefile = file[len(col)+1:]

        if not basefile:
            continue

        if any(exists(join(e, basefile)) for e in existing):
            debug(1, "%s already in existing collections, skipping." % basefile)
        else:
            __newcollection_populate_file(file, join(destcol, basefile), d)
}
do_newcollection[nostamp] = "1"
addtask newcollection

python do_newcollection_all () {
}
do_newcollection_all[nostamp] = "1"
do_newcollection_all[recrdeptask] = "do_newcollection"
addtask newcollection_all after do_newcollection

python () {
    __newcollection_setup_taskdeps(d)
}
