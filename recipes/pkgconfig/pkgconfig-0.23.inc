require pkgconfig.inc

SRC_URI += " \
            file://autofoo.patch \
            file://sysrootfix.patch \
            file://glibconfig-sysdefs.h \
           "
SRC_URI[md5sum] = "d922a88782b64441d06547632fd85744"
SRC_URI[sha256sum] = "08a0e072d6a05419a58124db864f0685e6ac96e71b2875bf15ac12714e983b53"

acpaths = "-I ."
do_configure_prepend () {
	install -m 0644 ${WORKDIR}/glibconfig-sysdefs.h glib-1.2.*/
}
