PACKAGES += "${PN}-bin"

# NB: ${base_libdir}/*${SOLIBSDEV} is included here because the shared libraries
# in ${base_libdir} do not follow the usual *.so.* naming convention, for instance
# libproc-3.2.7.so
FILES_${PN} = "${libexecdir} ${libdir}/lib*${SOLIBS} \
	    ${sysconfdir} ${sharedstatedir} ${localstatedir} \
	    ${base_libdir}/*${SOLIBS} ${base_libdir}/*${SOLIBSDEV} \
	    ${datadir}/${PN} ${libdir}/${PN}"
FILES_${PN}-dev = "${includedir} ${libdir}/lib*${SOLIBSDEV} ${libdir}/*.la \
		${libdir}/*.a ${libdir}/pkgconfig /lib/*.a /lib/*.o \
		${datadir}/aclocal ${bindir}/*-config"
FILES_${PN}-bin = "${bindir}/* ${sbindir}/* /bin/* /sbin/*"
