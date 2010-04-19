def join(*paths):
    """Like os.path.join but doesn't treat absolute RHS specially"""
    from os import sep
    from os.path import normpath

    return normpath(sep.join(paths))

def relative(src, dest=None):
    """ Return a relative path from src to dest(default=cwd).

    >>> relative("/usr/bin", "/tmp/foo/bar")
    ../../tmp/foo/bar

    >>> relative("/usr/bin", "/usr/lib")
    ../lib

    >>> relative("/tmp", "/tmp/foo/bar")
    foo/bar
    """
    if dest is None:
        dest = getcwd()

    if hasattr(os.path, "relpath"):
        return os.path.relpath(dest, src)
    else:
        from os import getcwd, sep
        from os.path import abspath, normpath

        srclist = abspath(src).split(sep)
        destlist = abspath(dest).split(sep)
        loc = [spath == dpath for spath, dpath in zip(srclist, destlist)].index(False)
        rellist = ([ ".." ] * (len(srclist) - loc)) + destlist[loc:]
        return sep.join(rellist)

def format_display(path, metadata):
    """ Prepare a path for display to the user. """
    rel = relative(metadata.getVar("TOPDIR", 1), path)
    if len(rel) > len(path):
        return path
    else:
        return rel
