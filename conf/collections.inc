# Take a list of directories in COLLECTIONS, in priority order (highest to
# lowest), and use those to populate BBFILES, BBFILE_COLLECTIONS,
# BBFILE_PATTERN_*, and BBFILE_PRIORITY_*.

COLLECTIONS = "${@' '.join(d.getVar('BBPATH', 1).split(':'))}"

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
        basename = os.path.basename(collection).split(os.path.extsep)[0]
        if namemap.get(basename):
            basename = "%s-%s" % (basename, hash(collection))
        namemap[basename] = collection
        collectionmap[collection] = basename

    for (collection, priority) in izip(collections, xrange(len(collections), 0, -1)):
        if not os.path.exists(collection):
            bb.fatal("Collection %s does not exist" % collection)

        name = collectionmap[collection]
        if not name:
            bb.fatal("Unable to determine collection name for %s" % collection)

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
