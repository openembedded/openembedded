require pixman.inc

PR = "${INC_PR}.0"

SRC_URI = "http://xorg.freedesktop.org/archive/individual/lib/${BPN}-${PV}.tar.gz \
file://0002-Fix-compilation-on-Win32.patch \
file://0003-test-Fix-tests-for-compilation-on-Windows.patch \
file://0004-test-Add-Makefile-for-Win32.patch \
file://0005-Do-not-include-unused-headers.patch \
file://0006-test-Silence-MSVC-warnings.patch \
file://0007-Main-loop-template-for-fast-single-pass-bilinear-sca.patch \
file://0008-test-check-correctness-of-bilinear_pad_repeat_get_sc.patch \
file://0009-SSE2-optimization-for-bilinear-scaled-src_8888_8888.patch \
file://0010-ARM-NEON-optimization-for-bilinear-scaled-src_8888_8.patch \
file://0011-test-In-image_endian_swap-use-pixman_image_get_forma.patch \
file://0012-test-Do-endian-swapping-of-the-source-and-destinatio.patch \
file://0013-ARM-use-prefetch-in-nearest-scaled-src_0565_0565.patch \
file://0014-ARM-common-macro-for-nearest-scaling-fast-paths.patch \
file://0015-ARM-assembly-optimized-nearest-scaled-src_8888_8888.patch \
file://0016-ARM-new-bilinear-fast-path-template-macro-in-pixman-.patch \
file://0017-ARM-NEON-common-macro-template-for-bilinear-scanline.patch \
file://0018-ARM-use-common-macro-template-for-bilinear-scaled-sr.patch \
file://0019-ARM-NEON-optimization-for-bilinear-scaled-src_8888_0.patch \
file://0020-ARM-NEON-optimization-for-bilinear-scaled-src_0565_x.patch \
file://0021-ARM-NEON-optimization-for-bilinear-scaled-src_0565_0.patch \
file://0022-ARM-a-bit-faster-NEON-bilinear-scaling-for-r5g6b5-so.patch \
file://0023-In-delegate_-src-dest-_iter_init-call-delegate-direc.patch \
file://0024-Fill-out-parts-of-iters-in-_pixman_implementation_-s.patch \
file://0025-Simplify-the-prototype-for-iterator-initializers.patch \
file://0026-test-Randomize-some-tests-if-PIXMAN_RANDOMIZE_TESTS-.patch \
file://0027-Add-simple-support-for-the-r8g8b8a8-and-r8g8b8x8-for.patch \
file://0028-Add-support-for-the-r8g8b8a8-and-r8g8b8x8-formats-to.patch \
file://0029-test-Fix-infinite-loop-in-composite.patch \
file://0030-ARM-tweaked-horizontal-weights-update-in-NEON-biline.patch \
file://0031-ARM-use-aligned-memory-writes-in-NEON-bilinear-scali.patch \
file://0032-ARM-support-for-software-pipelining-in-bilinear-macr.patch \
file://0033-ARM-use-less-ARM-instructions-in-NEON-bilinear-scali.patch \
file://0034-ARM-support-different-levels-of-loop-unrolling-in-bi.patch \
file://0035-ARM-pipelined-NEON-implementation-of-bilinear-scaled.patch \
file://0036-ARM-pipelined-NEON-implementation-of-bilinear-scaled.patch \
file://0037-Generic-C-implementation-of-pixman_blt-with-overlapp.patch \
file://0038-Support-of-overlapping-src-dst-for-pixman_blt_mmx.patch \
file://0039-Support-of-overlapping-src-dst-for-pixman_blt_sse2.patch \
file://0040-Support-of-overlapping-src-dst-for-pixman_blt_neon.patch \
"

SRC_URI[md5sum] = "b083fce3bd41ffd083e50dfe6612612d"
SRC_URI[sha256sum] = "ee22c24acc0c1b55a59aeeebfb3552038495d301e334608ac8e6af98172c748c"

NEON = " --disable-arm-neon "
NEON_armv7a = " "

EXTRA_OECONF = "${NEON} --disable-gtk"
