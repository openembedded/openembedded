DESCRIPTION = "AppWeb is an embedded HTTP Web server that has been designed with security in mind."
SECTION = "console/network"
LICENSE = "GPL"
SRC_URI = "http://www.mbedthis.com/software/appWeb-src-${PV}-1.tar.gz \
	   file://makerules.patch;patch=1 \
	   file://init.d.patch;patch=1 \
           file://libdb.patch;patch=1"
S = "${WORKDIR}/appWeb-${PV}"

APPWEB_HOST = "${@get_appweb_host(d, bb)}"
APPWEB_BUILD = "${BUILD_SYS}"

def get_appweb_host(d, bb):
    host = bb.data.getVar('HOST_SYS', d, 1)
    return host.replace('-linux-uclibc', '-linux')
    

#  --buildNumber=NUMBER     Set the build number part of the version (1.0.0.X).
#  --name=NAME              Set the full product name (BLD_NAME define).
#  --port=PORT              Set the default HTTP port to use for the product.
#  --product=NAME           Set the one word (no spaces) name of the product.
#  --setLibVersion=X.X.X    Set the shared library version number.
#  --setVersion=X.X.X       Set the product version number.
#  --sslPort=PORT           Set the default SSL port to use for the product.
#  --type=BUILD             Set the build type (DEBUG|RELEASE).
#
#  --enable-access-log      Enable logging of requests to the AppWeb access log.
#  --enable-assert          Build with assert checking.
#  --enable-config          Build with the ability to parse Apache-style config
#  --enable-cookie          Build with cookie handling support.
#  --enable-digest-auth     Build with digest authentication support.
#  --enable-fast-malloc     Build with the Mbedthis fast malloc.
#  --enable-if-modified     Build with HTTP If-Modified checking.
#  --enable-keep-alive      Build with HTTP Keep-Alive support.
#  --enable-log             Build with the AppWeb trace log facility.
#  --enable-modules         Build with the dynamically loaded modules capability.
#  --enable-multi-thread    Build AppWeb multi-threaded.
#  --disable-multi-thread   Build AppWeb single threaded.
#  --enable-rom-fs          Build with the ability to load web pages from ROM.
#  --enable-run-as-service  Build with the ability to run as a service/daemon.
#  --disable-run-as-service Do not include the ability to run as a service.
#  --enable-safe-strings    Enforce safe string handling.
#  --enable-session         Build with HTTP session support.
#  --enable-shared          Build an appWeb shared library and program. [default]
#  --enable-shared-libc     Link with the shared versions of libc.
#  --disable-shared-libc    Link with the static versions of libc.
#  --enable-squeeze         Build in squeeze mode for minimal memory footprint.
#  --disable-squeeze        Build for speed.
#  --enable-static          Build a static appWeb library and program. [default]
#  --disable-static         Do not build a static appWeb library and program.
#
#  --with-admin             Include the admin handler.
#  --with-auth              Include the authorization handler.
#  --with-c_api             Include the C API.
#  --with-cgi               Include the CGI handler.
#  --with-gacompat          Include GoAhead WebServer API compatibility.
#  --with-copy              Build support for the copy handler.
#  --with-egi               Include the EGI handler.
#  --with-esp               Include the ESP handler.
#  --with-ssl               Build support for the SSL protocol.
#  --with-upload            Build with the file upload handler
#  --with-xdb               Build with XDB 
#  Supported PACKAGE names: openssl, php4, php5
#  --with-PACKAGE=[builtin|, module]       
#                           Include support for the PACKAGE. Link into appWeb 
#                           statically and/or build as a module
#  --with-PACKAGE-dir=DIR   Set the source directory of the package
#  --with-PACKAGE-libs=libs Set a list of libraries to use when linking with
#                             the PACKAGE
#  --without-PACKAGE        Do not include support for the PACKAGE
EXTRA_OECONF = "--prefix=${prefix} \
		--docDir=${docdir}/${P} \
		--incDir=${includedir} \
		--libDir=${libdir} \
		--sbinDir=${sbindir} \
		--webDir=${localstatedir}/www \
		--build=${APPWEB_BUILD} \
		--host=${APPWEB_HOST} \
		--enable-keep-alive \
		--enable-multi-thread \
		--with-cgi=builtin \
		--enable-cookie \
		--enable-config-parse \
		--enable-config-save \
		--enable-digest-auth \
		--without-ssl \
--with-php5='loadable' \
--with-php5-dir='../../php-5.0.5-r0/php-5.0.5/libs' \
--with-php5-libs='php5 crypt expat xml2 m mysqlclient z' \
--with-php5-iflags='-I$(BLD_TOP)/$(BLD_PHP5_DIR)/.. -I$(BLD_TOP)/$(BLD_PHP5_DIR)/../main -I$(BLD_TOP)/$(BLD_PHP5_DIR)/../Zend -I$(BLD_TOP)/$(BLD_PHP5_DIR)/../TSRM'"

export IFLAGS = "${CPPFLAGS}"
export CC_FOR_BUILD = "${BUILD_CC}"
export LD_FOR_BUILD = "${BUILD_LD}"

LD_LIBRARY_PATH_prepend = "${S}/lib:"
LD_LIBRARY_PATH[export] = "1"
do_configure () {
	./configure ${EXTRA_OECONF}
}

do_compile () {
	sed -i 's:MAKE_IFLAGS:MAKE_LDFLAGS = -L${STAGING_LIBDIR}\nMAKE_IFLAGS:' ${S}/http/modules/php5/Makefile
#	find ${S} -type f | xargs sed -i 's:-I${STAGING_INCDIR}:-I${STAGING_INCDIR} -I../../../../../php-5.0.5-r0/php-5.0.5 -I../../../../../php-5.0.5-r0/php-5.0.5/Zend -I../../../../../php-5.0.5-r0/php-5.0.5/TSRM -I../../../../../php-5.0.5-r0/php-5.0.5/main:'
#	sed -i 's:/usr/lib:${STAGING_LIBDIR}:' ${S}/http/package/LINUX/http.files
#	sed -i 's:cpmod ${STAGING_LIBDIR}/:cpmod :' ${S}/http/package/LINUX/http.files
	oe_runmake build
	oe_runmake compile
}

do_stage () {
	:
}

do_install () {
	oe_runmake 'ROOT_DIR=${D}' install-all
}

#do_install () {
#	install -d ${D}${sbindir} ${D}${sysconfdir}/appWeb/lib \
#		   ${D}${libexecdir}/appWeb ${D}${libdir}
#	install -m 0755 appWeb/appWeb ${D}${sbindir}/
#	install -m 0644 appWeb/appWeb.conf ${D}${sysconfdir}/appWeb/
#	install -m 0755 bin/${APPWEB_OS}/* ${D}${libexecdir}/appWeb/
#	install -m 0755 lib/lib*.so* ${D}${sysconfdir}/appWeb/lib/
#}
