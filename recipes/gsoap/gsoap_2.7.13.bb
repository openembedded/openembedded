require gsoap_${PV}.inc

DEPENDS = "gsoap-native"

do_install_append() {
   install -d ${D}${libdir}
   for lib in libgsoapssl libgsoapssl++ libgsoap libgsoapck++ libgsoap++ libgsoapck
   do
       oe_libinstall -C gsoap $lib ${D}${libdir}
   done
}
                        

FILES_${PN} = "${bindir}/wsdl2h ${bindir}/soapcpp2"
FILES_${PN} += "${datadir}"

SRC_URI[md5sum] = "fffb49eb1db7ff03643a4313115dc3b1"
SRC_URI[sha256sum] = "3d40a528b8f3309f392945dca2ecaee5a698f4ee00a6036907a57c4f25a6a479"
