require linux.inc

COMPATIBLE_HOST = 'bfin.*-uclinux'

PV = "2.6.22.10+svnr${SRCPV}"

SRC_URI = "svn://sources.blackfin.uclinux.org/linux-kernel/;module=trunk \
           file://defconfig \
          "

S = "${WORKDIR}/trunk"

do_configure_prepend() {
       rm localversion.adi || true 
}


