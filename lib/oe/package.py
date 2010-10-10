import glob
import os.path
import oe.path

def files(pkg, d):
    """ Obtains a list of files to be included in a package.

    Starting from the FILES_<pkg> variable, it expands any glob.globs in the list,
    which removes missing files, and traverses any directories in the list.

    It does *not* remove files which are also in other packages, it's left
    to the user's discretion whether to allow overlap. """

    installdir = d.getVar("D", True)
    installdirlen = len(installdir)

    files = (d.getVar("FILES_%s" % pkg, True) or "").split()
    for globbed in (glob.glob(os.path.join(installdir, file[1:])) for file in files):
        for path in globbed:
            if os.path.isdir(path) and not os.path.islink(path):
                for file in oe.path.find(path):
                    yield file[installdirlen:]
            else:
                yield path[installdirlen:]
