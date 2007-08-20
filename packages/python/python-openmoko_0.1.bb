DESCRIPTION = "Python Bindings for the OpenMoko Platform"
AUTHOR = "Holger 'Zecke' Freyther"
LICENSE = "LGPL"
DEPENDS = "python-pygtk libmokoui2 libmokojournal2 libmokogsmd2"
SECTION = "devel/python"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/bindings;module=python;proto=http"
S = "${WORKDIR}/python"

inherit autotools distutils-base



