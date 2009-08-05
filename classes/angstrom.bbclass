# anonymous support class for angstrom
# 
# Features:
#
# * blacklist handling, set ANGSTROM_BLACKLIST_pn-blah = "message"
#

python () {
    import bb

    blacklist = bb.data.getVar("ANGSTROM_BLACKLIST", d, 1)
    pkgnm = bb.data.getVar("PN", d, 1)

    if blacklist:
	bb.note("Angstrom DOES NOT support %s because %s" % (pkgnm, blacklist))
        raise bb.parse.SkipPackage("Angstrom DOES NOT support %s because %s" % (pkgnm, blacklist))

}

