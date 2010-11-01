DESCRIPTION = "Fixup some miscompiled apps by making an extra symlink"
LICENSE = "MIT"

PACKAGE_ARCH = "all"
ALLOW_EMPTY_${PN} = "1"

pkg_postinst_${PN}() {
if [ "x$D" != "x" ]; then
	exit 1
fi
ln -sf /lib/libc.so.6 /lib/libc.so
}
