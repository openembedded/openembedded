inherit binconfig

PACKAGES += "${PN}-bin"

FILES_${PN} = "${libexecdir}/* ${libdir}/lib*${SOLIBS} \
            ${sysconfdir} ${sharedstatedir} ${localstatedir} \
            ${base_libdir}/*${SOLIBS} \
            ${datadir}/${PN} ${libdir}/${PN}/*"

FILES_${PN}-bin = "${bindir}/* ${sbindir}/* \
                ${base_bindir}/* ${base_sbindir}/*"
