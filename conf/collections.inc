# Take a list of directories in COLLECTIONS, in priority order (highest to
# lowest), and use those to populate BBFILES, BBFILE_COLLECTIONS,
# BBFILE_PATTERN_*, and BBFILE_PRIORITY_*.
#
# Specifying an archive in COLLECTIONS is also supported.  Any archives of a
# supported format will be unpacked into COLLECTIONS_UNPACKDIR and used from
# there.

COLLECTIONS = "${@' '.join(d.getVar('BBPATH', 1).split(':'))}"
COLLECTIONS_UNPACKDIR = "${TMPDIR}/collections"

def collection_unpack(collection, name, d):
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

    outpath = os.path.join(d.getVar("COLLECTIONS_UNPACKDIR", 1), name)

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
                bb.note("Using existing %s for collection '%s'" % (outpath, name))
                return outpath, False

        bb.note("Removing old unpacked collection at %s" % outpath)
        os.system("rm -rf %s" % outpath)

    try:
        cmd = (cmd for (exts, cmd) in handlers.iteritems()
                   for e in exts
                   if collection.endswith(e)).next()
        cmd = "cd %s && PATH=\"%s\" %s" % (outpath, d.getVar("PATH", 1), cmd)
    except StopIteration:
        bb.fatal("Unable to find unpack handler for %s" % collection)

    if not os.path.isdir(outpath):
        os.makedirs(outpath)

    bb.note("Unpacking %s to %s/" % (collection, outpath))
    ret = os.system(cmd % collection)
    if ret != 0:
        bb.fatal("Unable to unpack %s" % collection)

    md5out = open(md5file, "w")
    md5out.write(md5sum)
    md5out.close()
    return outpath, True

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
    for collection in collections:
        basename = os.path.basename(collection).split(os.path.extsep)[0]
        if namemap.get(basename):
            basename = "%s-%s" % (basename, hash(collection))
        namemap[basename] = collection
        collectionmap[collection] = basename

    unpackedthisexec = False
    oldbbpath = d.getVar("BBPATH", 1)
    bbpath = (oldbbpath or "").split(":")
    for (collection, priority) in izip(collections, xrange(len(collections), 0, -1)):
        if not os.path.exists(collection):
            bb.fatal("Collection %s does not exist" % collection)

        name = collectionmap[collection]
        if not name:
            bb.fatal("Unable to determine collection name for %s" % collection)

        if not os.path.isdir(collection):
            del collectionmap[collection]
            unpacked, unpackedthisexec = collection_unpack(collection, name, d)
            if unpacked:
                collection = unpacked
                collectionmap[collection] = name
                for dir in glob("%s/*/" % collection):
                    if not dir in bbpath:
                        bbpath.append(dir)
            else:
                bb.fatal("Unable to unpack collection %s" % collection)
        else:
            if not collection in bbpath:
                bbpath.append(collection)

        setifunset("BBFILE_PATTERN_%s" % name, "^%s/" % collection)
        setifunset("BBFILE_PRIORITY_%s" % name, str(priority))

    setifunset("BBFILE_COLLECTIONS", " ".join(collectionmap.values()))
    setifunset("BBFILES", " ".join(collectionmap.keys()))

    # Strip out the fallback bitbake.conf from BB_RUN_LOCATION
    bbpath = [os.path.realpath(dir) for dir in bbpath if os.path.exists(dir)]
    try:
        bbpath.remove(os.path.realpath(bb.data.expand("${BB_RUN_LOCATION}/../share/bitbake", d)))
    except (OSError, ValueError):
        pass

    from sets import Set
    d.setVar("BBPATH", ":".join(bbpath))
    if unpackedthisexec or Set(bbpath).symmetric_difference(Set(oldbbpath.split(":"))):
        bb.debug(1, "Re-executing bitbake with BBPATH of %s" % d.getVar("BBPATH", 0))
        import sys
        os.environ["BBPATH"] = d.getVar("BBPATH", 0)
        os.execvpe("bitbake", sys.argv, os.environ)

addhandler collections_eh
python collections_eh () {
    from bb.event import getName

    if getName(e) == "ConfigParsed":
        collections_setup(e.data)

    return NotHandled
}
