DESCRIPTION = "A boot profiling tool"
HOMEPAGE = "http://code.google.com/p/ubootchart/"
LICENSE="GPLv3"
PV = "0.1.0+svnr${SRCREV}"
PR = "r0"

SRC_URI="svn://ubootchart.googlecode.com/svn/;proto=http;module=trunk"
S = "${WORKDIR}/trunk"


do_patch() {
    sed -i "s/@VERSION@/${PV}-${PR}/" ${S}/ubootchartd
}

do_compile() {
        ${CC} ${CFLAGS} ${LDFLAGS} ${LIBS} ${INCLUDES} ${S}/ubootchartd_bin.c -o ubootchartd_bin
}

do_install() {
        install -m 0755 -d ${D}/sbin ${D}/etc/ubootchart ${D}${docdir}/ubootchart
        install -m 0755 ${S}/ubootchartd_bin ${D}/sbin
        install -m 0755 ${S}/ubootchartd ${D}/sbin
        install -m 0644 ${S}/ubootchart.conf ${D}/etc/ubootchart
        install -m 0755 ${S}/start.sh ${D}/etc/ubootchart
        install -m 0755 ${S}/finish.sh ${D}/etc/ubootchart
}
