require automake.inc
PR = "${INC_PR}.2"

SRC_URI += "file://0001-py-compile-compile-only-optimized-byte-code.patch \
		file://automake-dont-execute-perl.patch"

SRC_URI[automake.md5sum] = "c2972c4d9b3e29c03d5f2af86249876f"
SRC_URI[automake.sha256sum] = "5b159d3c0e0a1f87de71b68bcb9f1a1c49e9e71749c9b723f17e2e1e0295c7ae"
