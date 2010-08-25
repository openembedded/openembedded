LICENSE = "LGPL2.1"

SRC_URI = "http://www.opensc-project.org/files/opensc/opensc-${PV}.tar.gz \
	   "
SRC_URI[md5sum] = "98fa151e947941f9c3f27420fdf47c11"
SRC_URI[sha256sum] = "a9a42d6d51fb500f34248fcd0d4083c99d25bc5e74df60fe4efa19b5b4e6d890"

inherit autotools

FILES_${PN}-dev += " \
    ${libdir}/pkcs11-spy.so \
    ${libdir}/opensc-pkcs11.so \
    ${libdir}/onepin-opensc-pkcs11.so \
    ${libdir}/pkcs11/pkcs11-spy.so \
    ${libdir}/pkcs11/opensc-pkcs11.so \
    ${libdir}/pkcs11/onepin-opensc-pkcs11.so \
    "
