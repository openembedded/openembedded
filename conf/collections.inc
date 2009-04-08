# Take a list of directories in COLLECTIONS, in priority order (highest to
# lowest), and use those to populate BBFILES, BBFILE_COLLECTIONS,
# BBFILE_PATTERN_*, and BBFILE_PRIORITY_*.  By default, COLLECTIONS is
# prepopulated with the locations the user specified in their BBPATH.
# Note that it will not overwrite existing BBFILES or BBFILE_* variables, so
# you'll need to remove those from your config in order to use this.
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
                bb.debug(1, "Using existing %s for collection %s" % (outpath, name))
                return outpath

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
    return outpath

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
    globbed = (glob(path) for path in collections.split())
    collections = list(chain(*globbed))

    collectionmap = {}
    namemap = {}
    for collection in collections:
        if collection.endswith(os.sep):
            collection = collection[:-1]
        basename = os.path.basename(collection).split(os.path.extsep)[0]
        if namemap.get(basename):
            basename = "%s-%s" % (basename, hash(collection))
        namemap[basename] = collection
        collectionmap[collection] = basename

    for (collection, priority) in izip(collectionmap, xrange(len(collections), 0, -1)):
        if not os.path.exists(collection):
            bb.fatal("Collection %s does not exist" % collection)

        name = collectionmap[collection]
        if not name:
            bb.fatal("Unable to determine collection name for %s" % collection)

        if not os.path.isdir(collection):
            del collectionmap[collection]
            unpacked = collection_unpack(collection, name, d)
            if unpacked:
                collection = unpacked
                collectionmap[collection] = name
            else:
                bb.fatal("Unable to unpack collection %s" % collection)

        setifunset("BBFILE_PATTERN_%s" % name, "^%s/" % collection)
        setifunset("BBFILE_PRIORITY_%s" % name, str(priority))

    setifunset("BBFILE_COLLECTIONS", " ".join(collectionmap.values()))
    setifunset("BBFILES", " ".join(collectionmap.keys()))

addhandler collections_eh
python collections_eh () {
    from bb.event import getName

    if getName(e) == "ConfigParsed":
        collections_setup(e.data)

    return NotHandled
}
