DESCRIPTION = "nodeJS Evented I/O for V8 JavaScript"
HOMEPAGE = "http://nodejs.org"
LICENSE = "MIT"

DEPENDS = "openssl"

PR = "r1"

def nodejs_get_gcc_version(d):
    import subprocess,os,bb
    if os.path.exists(bb.data.getVar('TOOLCHAIN_PATH', d, 1)+'/bin/'+bb.data.getVar('TARGET_PREFIX', d, 1)+'gcc'):
        return subprocess.Popen([bb.data.getVar('TOOLCHAIN_PATH', d, 1)+'/bin/'+bb.data.getVar('TARGET_PREFIX', d, 1)+'gcc', '-v'], stderr=subprocess.PIPE).communicate()[1].splitlines()[-1].split()[2]

SRC_URI = " \
  http://nodejs.org/dist/node-v${PV}.tar.gz \
  file://libev-cross-cc_${PV}.patch \
"

# This patch should only be applied for earlier GCC versions.
SRC_URI += "${@["", "file://0001-Add-missing-compiler-flags-for-GCC-4.3.patch"][nodejs_get_gcc_version(d) <= "4.3.3"]}"

SRC_URI[md5sum] = "9e9e791e125f6a601ebc663dc99c72a8"
SRC_URI[sha256sum] = "09b1100ca6828eedbe52418fbeb3352d71c0b1ff3344c44a5af3efb80c5b908c"

S = "${WORKDIR}/node-v${PV}"

# v8 errors out if you have set CCACHE
CCACHE = ""

do_configure () {
  sed -i -e 's:/usr/lib:${STAGING_LIBDIR}:g' wscript
  sed -i -e 's:/usr/local/lib:${STAGING_LIBDIR}:g' wscript
  ./configure --prefix=${prefix} --without-snapshot
}

do_compile () {
  make
}

do_install () {
  DESTDIR=${D} oe_runmake install
}

BBCLASSEXTEND = "native"
