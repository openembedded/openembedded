DESCRIPTION = "config.{guess,sub} files"
SECTION = "base"
LICENSE = "GPL"
DEPENDS = ""
INHIBIT_DEFAULT_DEPS = "1"

FIXEDSRCDATE = "${@bb.data.getVar('FILE', d, 1).split('_')[-1].split('.')[0]}"
PV = "0.1+cvs${FIXEDSRCDATE}"
PR = "r7"

SRC_URI = "cvs://anonymous@cvs.sv.gnu.org/cvsroot/config;module=config;method=pserver;date=${FIXEDSRCDATE} \
	   file://config-guess-uclibc.patch \
           file://avr32.patch"
S = "${WORKDIR}/config"

do_compile() {
	:
}

do_install () {
	install -d ${D}${datadir}/gnu-config
	install -m 0644 config.guess config.sub ${D}${datadir}/gnu-config/
}

FILES_${PN} = "${datadir}/gnu-config"

BBCLASSEXTEND = "native"
NATIVE_INSTALL_WORKS = "1"
