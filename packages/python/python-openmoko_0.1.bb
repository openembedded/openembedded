DESCRIPTION = "Python Bindings for the Openmoko Platform"
AUTHOR = "Holger 'Zecke' Freyther"
LICENSE = "LGPL"
DEPENDS = "python-pygtk libmokoui2 libmokojournal2 libmokogsmd2"
SECTION = "devel/python"
PR = "r1"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/bindings;module=python;proto=http \
	   file://python-path.patch;patch=1;maxdate=20070829"

S = "${WORKDIR}/python"

inherit autotools distutils-base

EXTRA_OECONF += "--with-python-includes=${STAGING_INCDIR}/../"
