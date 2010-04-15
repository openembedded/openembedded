def join(a, *p):
    """Like os.path.join but doesn't treat absolute RHS specially"""
    path = a
    for b in p:
        if path == '' or path.endswith('/'):
            path +=  b
        else:
            path += '/' + b
    return path

def relative(src, dest):
    """ Return a relative path from src to dest.

    >>> relative("/usr/bin", "/tmp/foo/bar")
    ../../tmp/foo/bar

    >>> relative("/usr/bin", "/usr/lib")
    ../lib

    >>> relative("/tmp", "/tmp/foo/bar")
    foo/bar
    """
    from os.path import sep, pardir, normpath, commonprefix

    destlist = normpath(dest).split(sep)
    srclist = normpath(src).split(sep)

    # Find common section of the path
    common = commonprefix([destlist, srclist])
    commonlen = len(common)

    # Climb back to the point where they differentiate
    relpath = [ pardir ] * (len(srclist) - commonlen)
    if commonlen < len(destlist):
        # Add remaining portion
        relpath += destlist[commonlen:]

    return sep.join(relpath)

def format_display(path, metadata):
    """ Prepare a path for display to the user. """
    rel = relative(metadata.getVar("TOPDIR", 1), path)
    if len(rel) > len(path):
        return path
    else:
        return rel
