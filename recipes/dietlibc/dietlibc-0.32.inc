SRC_URI = " \
        http://www.kernel.org/pub/linux/libs/dietlibc/dietlibc-${PV}.tar.bz2 \
        file://ccache.patch \
        file://ceil.patch \
        file://getrlimit.patch \
"
SRC_URI[md5sum] = "0098761c17924c15e21d25acdda4a8b5"
SRC_URI[sha256sum] = "6613a2cae3b39e340779735d7500d284f5a691c5ed67e59a6057e0888726e458"

# SMP build is broken
PARALLEL_MAKE = ""

# prefer the 'git' version which fixes lot of issues
DEFAULT_PREFERENCE = "-2"

# ARM EABI not fixable without complex patches
DEFAULT_PREFERENCE_arm = "-99"

do_configure_append () {
    install -d -m 0755 bin-${DIETLIBC_BUILD_ARCH}
    install -d -m 0755 bin-${DIETLIBC_TARGET_ARCH}

    sed -i -e 's!\$(CROSS)strip!$(STRIP)!g' Makefile
}
