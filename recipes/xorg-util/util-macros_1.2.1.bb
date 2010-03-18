require util-macros.inc

# Version 1.2.1 uses plain `gcc' for checking the compiler version.
# Instead, the cross compiler must be used. Whenever upgrading to
# a new version, please recheck for this problem, otherwise it breaks
# builds with older gcc versions!
SRC_URI += " file://cross-compiler-for-checking.patch;patch=1"
PR = "${INC_PR}.0"
SRC_URI[archive.md5sum] = "81b9746d6202ccf0b4a498cfd0731e71"
SRC_URI[archive.sha256sum] = "f3804f02f51a1be243ce7413dc67dca774f000686f8f2efedc77203a1962d401"
