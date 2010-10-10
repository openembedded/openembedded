import os

def join(*paths):
    """Like os.path.join but doesn't treat absolute RHS specially"""
    return os.path.normpath("/".join(paths))

def relative(src, dest):
    """ Return a relative path from src to dest.

    >>> relative("/usr/bin", "/tmp/foo/bar")
    ../../tmp/foo/bar

    >>> relative("/usr/bin", "/usr/lib")
    ../lib

    >>> relative("/tmp", "/tmp/foo/bar")
    foo/bar
    """

    if hasattr(os.path, "relpath"):
        return os.path.relpath(dest, src)
    else:
        destlist = os.path.normpath(dest).split(os.path.sep)
        srclist = os.path.normpath(src).split(os.path.sep)

        # Find common section of the path
        common = os.path.commonprefix([destlist, srclist])
        commonlen = len(common)

        # Climb back to the point where they differentiate
        relpath = [ os.path.pardir ] * (len(srclist) - commonlen)
        if commonlen < len(destlist):
            # Add remaining portion
            relpath += destlist[commonlen:]

        return os.path.sep.join(relpath)

def format_display(path, metadata):
    """ Prepare a path for display to the user. """
    rel = relative(metadata.getVar("TOPDIR", 1), path)
    if len(rel) > len(path):
        return path
    else:
        return rel

def remove(path, recurse=True):
    """Equivalent to rm -f or rm -rf"""
    import os, errno, shutil
    try:
        os.unlink(path)
    except OSError, exc:
        if recurse and exc.errno == errno.EISDIR:
            shutil.rmtree(path)
        elif exc.errno != errno.ENOENT:
            raise

def symlink(source, destination, force=False):
    """Create a symbolic link"""
    import os, errno
    try:
        if force:
            remove(destination)
        os.symlink(source, destination)
    except OSError, e:
        if e.errno != errno.EEXIST or os.readlink(destination) != source:
            raise

def find(dir, **walkoptions):
    """ Given a directory, recurses into that directory,
    returning all files as absolute paths. """

    for root, dirs, files in os.walk(dir, **walkoptions):
        for file in files:
            yield os.path.join(root, file)
