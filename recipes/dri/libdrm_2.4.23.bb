require libdrm.inc

PR = "${INC_PR}.0"

SRC_URI += "file://glamo.patch"

SRC_URI[md5sum] = "7577ff36ec364d88fae466d4f7fc5fc6"
SRC_URI[sha256sum] = "c0f06d68c3edba7a1ad937f5481a8c287efd4cd368cee66cd9e678b06a911c18"

do_compile_prepend_libc-uclibc() {
	eval "${@base_contains('DISTRO_FEATURES', 'largefile', '', 'sed -i -e "/_FILE_OFFSET_BITS/d" ${S}/libkms/intel.c', d)}"
	eval "${@base_contains('DISTRO_FEATURES', 'largefile', '', 'sed -i -e "/_FILE_OFFSET_BITS/d" ${S}/libkms/vmwgfx.c', d)}"
	eval "${@base_contains('DISTRO_FEATURES', 'largefile', '', 'sed -i -e "/_FILE_OFFSET_BITS/d" ${S}/libkms/nouveau.c', d)}"
}
