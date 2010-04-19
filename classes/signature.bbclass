# Generate a signature / hash from the metadata
#
# Using a blacklist rather than a whitelist is safest, at least if you're
# utilizing the signature in your pstage package filenames, as the failure
# mode for blacklist is an unnecessary rebuild from source, whereas the
# failure case for a whitelist is use of incorrect binaries.

BB_HASH_BLACKLIST += "BUILDSTART DATE TIME DATETIME \
                      __* *DIR \
                      BB_*"

def get_data_hash(d):
    from fnmatch import fnmatchcase

    try:
        signature = d.hash()
    except AttributeError:
        blacklist = (d.getVar("BB_HASH_BLACKLIST", True) or "").split()
        items = ((key, repr(d.getVar(key, False)))
                 for key in d.keys()
                 if not any(fnmatchcase(key, pattern) for pattern in blacklist))
        signature = hash(frozenset(items))
    return str(signature)

SIGNATURE = "${@get_data_hash(d.getVar('__RECIPEDATA', False) or d)}"

python () {
    d.setVar("__RECIPEDATA", d)
}
