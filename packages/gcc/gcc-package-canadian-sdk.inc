require gcc-package-sdk.inc

PACKAGES += "libgcc libgcc-dev libgfortran-dev libmudflap libmudflap-dev"

FILES_libgcc = "${libdir}/libgcc*.so.*"
FILES_libgcc-dev = "${libdir}/libgcc*.so"

FILES_libstdc++ = "${libdir}/libstdc++.so.*"
FILES_libstdc++-dev = "\
  ${incluedir}/c++/${BINV} \
  ${libdir}/libstdc++.so \
  ${libdir}/libstdc++.la \
  ${libdir}/libstdc++.a \
  ${libdir}/libsupc++.la \
  ${libdir}/libsupc++.a \
"

FILES_libgfortran-dev = "${libdir}/libgfortran.a \
                         ${libdir}/libgfortran.so \
                         ${libdir}/libgfortranbegin.a"

FILES_libmudflap = "${libdir}/libmudflap*.so.*"
FILES_libmudflap-dev = "\
  ${libdir}/libmudflap*.so \
  ${libdir}/libmudflap*.a \
  ${libdir}/libmudflap*.a \
"

# Packages emitted by our gcc-cross builds.
#
INHIBIT_PACKAGE_STRIP ?= ""
OLD_INHIBIT_PACKAGE_STRIP := "${INHIBIT_PACKAGE_STRIP}"
INHIBIT_PACKAGE_STRIP = "1"

python do_package() {
	if bb.data.getVar('DEBIAN_NAMES', d, 1):
		bb.data.setVar('PKG_libgcc', 'libgcc1', d)
	bb.build.exec_func('package_do_package', d)
}
