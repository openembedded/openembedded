BASEPN = "gsmd-lips"
CONFLICTNAME = "gsmd-devel gsmd"

require gsmd.inc

RPROVIDES_${PN} = "libgsmd0 libgsmd gsmd gsmd-devel libtapi libgsmd-dev"

PV = "0.0+svnr${SRCREV}"
PR = "r2"

SRC_URI = "svn://projects.linuxtogo.org/svn/gpephone/trunk/source/;module=gsm \
           file://stdint.patch;patch=1;pnum=0 \
           file://gsmd \
           file://default"

