# Copyright (c) 2009 MontaVista Software, Inc.  All rights reserved.
#
# Released under the MIT license (see COPYING.MIT for the terms)
#
# Take a list of directories in COLLECTIONS, in priority order (highest to
# lowest), and use those to populate BBFILES, BBFILE_COLLECTIONS,
# BBFILE_PATTERN_*, and BBFILE_PRIORITY_*.
#
# Specifying an archive in COLLECTIONS is also supported.  Any archives of a
# supported format will be unpacked into COLLECTIONS_UNPACKDIR and used from
# there.

COLLECTIONS = "${@' '.join(d.getVar('BBPATH', 1).split(':'))}"
COLLECTIONS_UNPACKDIR = "${TMPDIR}/collections"

COLLECTIONINFO = "${@get_collection(d.getVar('FILE', 1), d)}"

def has_collection(name, d):
    for (uniquename, info) in d.getVar("COLLECTIONSINFO", 1).iteritems():
        if info["name"] == name:
            return True
    return False

def get_collection(file, d):
    if not os.path.isabs(file):
        file = bb.which(d.getVar("BBPATH", 1), file)
    filedir = os.path.realpath(os.path.dirname(file))
    for (uniquename, info) in d.getVar("COLLECTIONSINFO", 1).iteritems():
        path = os.path.realpath(info["path"])
        if filedir.startswith(path + os.path.sep):
            return info

def collection_unpack(collection, d):
    """ Unpack a collection archive and return the path to it. """
    import bb
    import os
    from md5 import md5

    handlers = {
        ("tar"): "tar x --no-same-owner -f %s",
        ("tar.gz", "tgz", "tar.Z"): "tar xz --no-same-owner -f %s",
        ("tar.bz2", "tbz", "tbz2"): "tar xj --no-same-owner -f %s",
        ("zip", "jar"): "unzip -q -o %s",
    }

    basename = os.path.basename(collection)
    try:
        cmd, name = ((cmd, basename[:-len(e)-1]) for (exts, cmd) in handlers.iteritems()
                     for e in exts
                     if basename.endswith(e)).next()
    except StopIteration:
        bb.fatal("No method available to unpack %s (unsupported file type?)" % collection)
    else:
        outpath = os.path.join(d.getVar("COLLECTIONS_UNPACKDIR", 1), name)
        cmd = "cd %s && PATH=\"%s\" %s" % (outpath, d.getVar("PATH", 1), cmd)

    try:
        collectiondata = open(collection, "r").read()
    except IOError:
        bb.fatal("Unable to open %s to calculate md5 sum" % collection)

    md5obj = md5()
    md5obj.update(collectiondata)
    md5sum = md5obj.hexdigest()

    md5file = os.path.join(outpath, "md5")
    if os.path.exists(md5file):
        try:
            oldmd5sum = open(md5file).read()
        except IOError:
            pass
        else:
            if oldmd5sum == md5sum:
                bb.debug(1, "Using existing %s for collection '%s'" % (outpath, name))
                return outpath, False, name

        bb.note("Removing old unpacked collection at %s" % outpath)
        os.system("rm -rf %s" % outpath)

    if not os.path.isdir(outpath):
        os.makedirs(outpath)

    bb.note("Unpacking %s to %s/" % (collection, outpath))
    ret = os.system(cmd % collection)
    if ret != 0:
        bb.fatal("Unable to unpack %s" % collection)

    md5out = open(md5file, "w")
    md5out.write(md5sum)
    md5out.close()
    return outpath, True, name

def collections_setup(d):
    """ Populate collection and bbfiles metadata from the COLLECTIONS var. """
    import bb
    import os
    from itertools import izip, chain
    from glob import glob

    def setifunset(k, v):
        if d.getVar(k, 0) is None:
            d.setVar(k, v)

    collections = d.getVar("COLLECTIONS", 1)
    if not collections:
        return

    bb.debug(1, "Processing COLLECTIONS (%s)" % collections)

    globbed = []
    for path in collections.split():
        paths = glob(os.path.normpath(path))
        if not paths:
            bb.msg.warn(None, "No matches in filesystem for %s in COLLECTIONS" % path)
        globbed += paths
    collections = globbed

    collectionmap = {}
    namemap = {}
    collectioninfo = {}
    unpackedthisexec = False
    oldbbpath = d.getVar("BBPATH", 1)
    bbpath = (oldbbpath or "").split(":")
    for (collection, priority) in izip(collections, xrange(len(collections), 0, -1)):
        if not os.path.exists(collection):
            bb.fatal("Collection %s does not exist" % collection)

        origpath = collection
        if not os.path.isdir(collection):
            unpacked, unpackedthisexec, name = collection_unpack(collection, d)
            if unpacked:
                collection = unpacked
                for dir in glob("%s/*/" % collection):
                    if not dir in bbpath:
                        bbpath.append(dir)
            else:
                bb.fatal("Unable to unpack collection %s" % collection)
        else:
            name = os.path.basename(collection)
            if not collection in bbpath:
                bbpath.append(collection)

        if namemap.get(name):
            name = "%s-%s" % (name, hash(collection))
        namemap[name] = collection
        collectionmap[collection] = name

        collectioninfo[name] = {
            "name": name,
            "originalpath": origpath,
            "path": collection,
            "priority": priority,
        }

        setifunset("BBFILE_PATTERN_%s" % name, "^%s/" % collection)
        setifunset("BBFILE_PRIORITY_%s" % name, str(priority))

    d.setVar("COLLECTIONSINFO", collectioninfo)

    setifunset("BBFILE_COLLECTIONS", " ".join(collectionmap.values()))
    setifunset("BBFILES", " ".join(collectionmap.keys()))

    bbpath = [os.path.realpath(dir) for dir in bbpath if os.path.exists(dir)]
    d.setVar("BBPATH", ":".join(bbpath))
    if unpackedthisexec or (set(bbpath) != set(oldbbpath.split(":"))):
        import sys
        bb.debug(1, "Re-executing bitbake with BBPATH of %s" % d.getVar("BBPATH", 0))
        os.environ["BBPATH"] = d.getVar("BBPATH", 0)
        # FIXME: This exports a bogus PYTHONPATH to OE recipes resulting in massive breakages: 
        # http://thread.gmane.org/gmane.comp.handhelds.openembedded/30163
        # os.environ["PYTHONPATH"] = ":".join(sys.path)
        sys.argv.insert(0, sys.executable)
        os.execvpe(sys.executable, sys.argv, os.environ)

addhandler collections_eh
python collections_eh () {
    from bb.event import getName

    if getName(e) == "ConfigParsed":
        collections_setup(e.data)

    return NotHandled
}
