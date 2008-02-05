DESCRIPTION = "Open Package Manager"
DESCRIPTION_libipkg = "Open Package Manager Library"
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "curl gpgme pth"
SRC_URI = "svn://svn.openmoko.org/trunk/src/target/;module=opkg;proto=http"

S = "${WORKDIR}/opkg"

inherit autotools pkgconfig

do_stage() {
        oe_libinstall -so libopkg ${STAGING_LIBDIR}
        install -d ${STAGING_INCDIR}/libopkg/
        for f in *.h
        do
                install -m 0644 $f ${STAGING_INCDIR}/libopkg/
        done
}

PACKAGES =+ "libopkg-dev libopkg"

FILES_libopkg-dev = "${libdir}/*.a ${libdir}/*.la ${libdir}/*.so"
FILES_libopkg = "${libdir}/*.so.*"

