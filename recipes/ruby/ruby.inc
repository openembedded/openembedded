DESCRIPTION = "Ruby is an interpreted scripting language \
for quick and easy object-oriented programming."
SECTION = "devel/ruby"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "ruby-native zlib openssl"
DEPENDS_virtclass-native = ""

INC_PR = "r1"

SHRT_VER = "${@bb.data.getVar('PV',d,1).split('.')[0]}.${@bb.data.getVar('PV',d,1).split('.')[1]}"
SRC_URI = "ftp://ftp.ruby-lang.org/pub/ruby/${SHRT_VER}/ruby-${PV}.tar.gz \
           file://extmk_run.patch;patch=1 \
           file://openssl.patch;patch=1 \
           file://disable_wide_getaddrinfo_check.patch;patch=1"

S = "${WORKDIR}/ruby-${PV}"

inherit autotools

# This snippet lets compiled extensions which rely on external libraries,
# such as zlib, compile properly.  If we don't do this, then when extmk.rb
# runs, it uses the native libraries instead of the target libraries, and so
# none of the linking operations succeed -- which makes extconf.rb think
# that the libraries aren't available and hence that the extension can't be
# built.

do_configure_prepend() {
	sed -i "s#%%TARGET_CFLAGS%%#$TARGET_CFLAGS#; s#%%TARGET_LDFLAGS%%#$TARGET_LDFLAGS#" ${S}/common.mk
	rm -rf ${S}/ruby/
}
