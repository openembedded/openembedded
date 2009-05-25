require cherokee_${PV}.bb

DEPENDS = "libpcre"

FILESPATHPKG =. "cherokee-${PV}:cherokee:"

S = "${WORKDIR}/cherokee-${PV}"

EXTRA_OECONF = "--disable-tls --disable-static --disable-nls"

# Fix up files - the ${PN} in the defaults expand to cherokee-nossl
# but we are actually installing into cherokee.
FILES_${PN} += "${datadir}/cherokee ${libdir}/cherokee/*"
FILES_${PN}-dbg += "${libdir}/cherokee/.debug"
