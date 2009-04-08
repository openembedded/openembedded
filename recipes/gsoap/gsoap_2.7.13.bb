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
