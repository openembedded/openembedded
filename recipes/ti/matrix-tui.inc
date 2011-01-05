DESCRIPTION = "Matrix TUI"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrix_tui/"
LICENSE = "BSD"
SECTION = "multimedia"
PRIORITY = "optional"
DEPENDS = "libxml2 zlib ncurses"

INC_PR = "r7"

COMPATIBLE_MACHINE = "(omapl138|omap3)"

PLATFORM_am37x-evm = "am3715"
PLATFORM_beagleboard = "am3715"
PLATFORM_am3517-evm = "am3517"
PLATFORM_am180x-evm = "am180x"
PLATFORM_am181x-evm = "am181x"
PLATFORM_da850-omapl138-evm = "am180x"

SRC_URI = "svn://gforge.ti.com/svn/matrix_tui/;module=trunk;proto=https;user=anonymous;pswd='' \
	file://init \
"

S = "${WORKDIR}/trunk"

# Do not auto-start TUI by default, uncomment otherwise
#inherit update-rc.d
#INITSCRIPT_NAME = "matrix-tui"
#INITSCRIPT_PARAMS = "defaults 99"

do_configure() {
	sed -i -e 's:PATH=${LINUX_DEVKIT_PATH}/arm-none-linux-gnueabi:PATH ?= ${LINUX_DEVKIT_PATH}/arm-none-linux-gnueabi:' makefile.init
	sed -i -e 's|LIBS :=|LIBS := ${LDFLAGS} |' Release/objects.mk
}

do_compile() {
	# don't build debug version
	touch debug
	export CROSS_COMPILE=${TARGET_PREFIX}
	export TUI_INCLUDE_PATH=${STAGING_INCDIR}
	export XML_INCLUDE_PATH=${STAGING_INCDIR}/libxml2
	export TUI_LIB_PATH=${STAGING_LIBDIR}
	make release
}

do_install() {
	export PLATFORM=${PLATFORM}
	make DESTDIR=${D} install
	install -d ${D}${sysconfdir}/init.d/
	install -c -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/matrix-tui
}

FILES_${PN} += "${datadir}/matrix/*"
