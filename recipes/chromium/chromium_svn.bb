DESCRIPTION = "Google Chrome browser"
LICENSE = "BSD"

DEPENDS = "xextproto cairo nss"

SRCREV = "34027"
PV = "0.1+svnr${SRCREV}"

SRC_URI = "svn://src.chromium.org/svn/trunk/;module=src;proto=http \
           git://git.chromium.org/cros.git;protocol=git;rev=07f1fc0ce7a4bbd57f6b057435ad86f0a98e073d\
           http://src.chromium.org/svn/trunk/tools/depot_tools.tar.gz;name=depot \
           file://include.gypi \
           file://gypi.patch;patch=1 \
"

SRC_URI[depot.md5sum] = "0d0f198a2b3c5495f75d95b867ae89b4"
SRC_URI[depot.sha256sum] = "1ad32db3b1028da622dae6be76564e4c926647d7f839d808897a9b33a1709b68"

S = "${WORKDIR}/src"

custom_cached_svn() {
	oenote "Dealing with ${1}"
	localpath="${DL_DIR}/chromium_`echo ${1} | sed -e 's|\/|\.|g'`_${3}.tbz2"
	mkdir -p ${2}
	if [ -f ${localpath} ]; then
		oenote "Extracting ${localpath}"
		tar -xpf ${localpath} -C ${2}
	else
		oenote "checkout and creating ${localpath}"
		svn checkout http://${1} ${2} --revision ${3}
		cd ${2}
		tar -cjpf ${localpath} .
	fi
}

do_fetch_post() {
	custom_cached_svn "google-breakpad.googlecode.com/svn/trunk/src" "${S}/breakpad/src" 432
	custom_cached_svn "src.chromium.org/svn/trunk/deps/support" "${S}/build/util/support" 20411
	custom_cached_svn "svn.webkit.org/repository/webkit/trunk/LayoutTests/fast/events" "${S}/chrome/test/data/layout_tests/LayoutTests/fast/events" 51794
	custom_cached_svn "svn.webkit.org/repository/webkit/trunk/LayoutTests/fast/js/resources" "${S}/chrome/test/data/layout_tests/LayoutTests/fast/js/resources" 51794
	custom_cached_svn "svn.webkit.org/repository/webkit/trunk/LayoutTests/fast/workers" "${S}/chrome/test/data/layout_tests/LayoutTests/fast/workers" 51794
	custom_cached_svn "svn.webkit.org/repository/webkit/trunk/LayoutTests/http/tests/resources" "${S}/chrome/test/data/layout_tests/LayoutTests/http/tests/resources" 51794
	custom_cached_svn "svn.webkit.org/repository/webkit/trunk/LayoutTests/http/tests/workers" "${S}/chrome/test/data/layout_tests/LayoutTests/http/tests/workers" 51794
	custom_cached_svn "svn.webkit.org/repository/webkit/trunk/LayoutTests/http/tests/xmlhttprequest" "${S}/chrome/test/data/layout_tests/LayoutTests/http/tests/xmlhttprequest" 51794
	custom_cached_svn "svn.webkit.org/repository/webkit/trunk/LayoutTests/storage/domstorage" "${S}/chrome/test/data/layout_tests/LayoutTests/storage/domstorage" 51794
	custom_cached_svn "src.chromium.org/svn/trunk/deps/reference_builds" "${S}/chrome/tools/test/reference_build" 33840
	custom_cached_svn "google-url.googlecode.com/svn/trunk" "${S}/googleurl" 121
	custom_cached_svn "nativeclient.googlecode.com/svn/trunk/src/native_client" "${S}/native_client" 1067
	custom_cached_svn "open-vcdiff.googlecode.com/svn/trunk" "${S}/sdch/open-vcdiff" 28
	custom_cached_svn "googletest.googlecode.com/svn/trunk" "${S}/testing/gtest" 336
	custom_cached_svn "src.chromium.org/svn/trunk/deps/third_party/WebKit" "${S}/third_party/WebKit" 33467
	custom_cached_svn "svn.webkit.org/repository/webkit/trunk/JavaScriptCore" "${S}/third_party/WebKit/JavaScriptCore" 51794
	custom_cached_svn "svn.webkit.org/repository/webkit/trunk/LayoutTests" "${S}/third_party/WebKit/LayoutTests" 51794
	custom_cached_svn "svn.webkit.org/repository/webkit/trunk/WebCore" "${S}/third_party/WebKit/WebCore" 51794
	custom_cached_svn "svn.webkit.org/repository/webkit/trunk/WebKit/chromium" "${S}/third_party/WebKit/WebKit/chromium" 51794
	custom_cached_svn "svn.webkit.org/repository/webkit/trunk/WebKitTools/pywebsocket" "${S}/third_party/WebKit/WebKitTools/pywebsocket" 57720
#	custom_cached_svn "src.chromium.org/svn/trunk/deps/third_party/ffmpeg/binaries/linux" "${S}/third_party/ffmpeg/binaries/chromium/linux/ia32" 33521
#	custom_cached_svn "src.chromium.org/svn/trunk/deps/third_party/ffmpeg/binaries/linux_dbg" "${S}/third_party/ffmpeg/binaries/chromium/linux/ia32_dbg" 33521
#	custom_cached_svn "src.chromium.org/svn/trunk/deps/third_party/ffmpeg/binaries/linux_64" "${S}/third_party/ffmpeg/binaries/chromium/linux/x64" 33521
#	custom_cached_svn "src.chromium.org/svn/trunk/deps/third_party/ffmpeg/binaries/linux_64_dbg" "${S}/third_party/ffmpeg/binaries/chromium/linux/x64_dbg" 33521
	custom_cached_svn "src.chromium.org/svn/trunk/deps/third_party/ffmpeg/patched-ffmpeg-mt" "${S}/third_party/ffmpeg/source/patched-ffmpeg-mt" 44766
	custom_cached_svn "src.chromium.org/svn/trunk/deps/third_party/hunspell128" "${S}/third_party/hunspell" 30191
	custom_cached_svn "src.chromium.org/svn/trunk/deps/third_party/icu42" "${S}/third_party/icu" 33767
	custom_cached_svn "ots.googlecode.com/svn/trunk" "${S}/third_party/ots" 23
	custom_cached_svn "protobuf.googlecode.com/svn/trunk" "${S}/third_party/protobuf2/src" 219
	custom_cached_svn "skia.googlecode.com/svn/trunk/include" "${S}/third_party/skia/include" 451
	custom_cached_svn "skia.googlecode.com/svn/trunk/src" "${S}/third_party/skia/src" 451
	custom_cached_svn "src.chromium.org/svn/trunk/deps/third_party/xdg-utils" "${S}/third_party/xdg-utils" 29103
	custom_cached_svn "src.chromium.org/svn/trunk/deps/third_party/yasm/patched-yasm" "${S}/third_party/yasm/source/patched-yasm" 29937
	custom_cached_svn "gyp.googlecode.com/svn/trunk" "${S}/tools/gyp" 766
	custom_cached_svn "src.chromium.org/svn/trunk/deps/page_cycler/acid3" "${S}/tools/page_cycler/acid3" 19546
	custom_cached_svn "v8.googlecode.com/svn/trunk" "${S}/v8" 3431
}

addtask fetch_post before do_unpack after do_fetch

do_configure() {
	if [ ! -e ${S}/third_party/cros ] ; then
		mv ${WORKDIR}/git ${S}/third_party/cros/
	fi
	cd ${WORKDIR}
	export GYP_GENERATORS=make
	export PATH=${WORKDIR}/depot_tools:"$PATH"

	rm -f ${S}/tools/gyp/pylib/gyp/__init__.pyc
	rm -f ${S}/tools/gyp/pylib/gyp/__init__.pyo
	sed -e 's|__PATH__TO_BE_REPLACED__|"${WORKDIR}/include.gypi"|' -i ${S}/tools/gyp/pylib/gyp/__init__.py
	sed -e "s|__PATH__TO_BE_REPLACED__||" -i ${WORKDIR}/include.gypi

	if [ ! -e ${WORKDIR}/.gclient ] ; then
		depot_tools/gclient config http://src.chromium.org/svn/trunk/src
	fi
	# This is the command lines to download everything but it's done in do_fetch_post
	#depot_tools/gclient sync --revision src@${SRCREV} --force --verbose
	depot_tools/gclient runhooks --force
}

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
	cd ${S}
	export CROSSTOOL=${CROSS_DIR}/bin/${TARGET_PREFIX}
	export AR=${CROSSTOOL}ar
	export AS=${CROSSTOOL}as
	export RANLIB=${CROSSTOOL}ranlib
	oe_runmake -r ${PARALLEL_MAKE} V=1 BUILDTYPE=Release chrome
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${bindir}/chrome/
	install -m 0755 ${S}/out/Release/chrome ${D}${bindir}/chrome/
	install -m 0644 ${S}/out/Release/chrome.pak ${D}${bindir}/chrome/
	install -m 0644 ${S}/out/Release/product_logo_48.png ${D}${bindir}/chrome/
	install -d ${D}${bindir}/chrome/locales/
	install -m 0644 ${S}/out/Release/locales/en-US.pak ${D}${bindir}/chrome/locales
	cp -a ${S}/out/Release/obj ${D}${bindir}/chrome/
	cp -a ${S}/out/Release/obj.target ${D}${bindir}/chrome/
	cp -a ${S}/out/Release/resources ${D}${bindir}/chrome/

	find ${D}${bindir}/chrome/ -name "*.d" -delete
	find ${D}${bindir}/chrome/ -name "*.o" -delete
	find ${D}${bindir}/chrome/ -name "*.a" -delete
	find ${D}${bindir}/chrome/ -name "*.cpp" -delete
	find ${D}${bindir}/chrome/ -name "*.h" -delete
	find ${D}${bindir}/chrome/ -name "*.cc" -delete
}

FILES_${PN} = "/usr/bin/chrome/"
FILES_${PN}-dbg = "/usr/bin/chrome/.debug/"

