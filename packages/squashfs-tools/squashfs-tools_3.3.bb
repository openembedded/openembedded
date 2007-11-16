require squashfs-tools.inc
PR = "r0"

# some release have .tgz, some have .tar.gz, so keep that outside the .inc file

SRC_URI = "${SOURCEFORGE_MIRROR}/squashfs/squashfs${@bb.data.getVar('PV',d,1).replace('r','-r')}.tgz \
file://Makefile.patch;patch=1"

