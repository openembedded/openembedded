require squashfs-tools.inc
PR = "r0"

DEFAULT_PREFERENCE = "-1"

# some release have .tgz, some have .tar.gz, so keep that outside the .inc file

#http://ovh.dl.sourceforge.net/sourceforge/squashfs/squashfs4.0.tar.gz

SRC_URI = "${SOURCEFORGE_MIRROR}/squashfs/squashfs${@bb.data.getVar('PV',d,1).replace('r','-r')}.tar.gz \
file://Makefile.patch;patch=1"

