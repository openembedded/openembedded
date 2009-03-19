DESCRIPTION = "OpenWRT's CPU Benchmark"
HOMEPAGE = "http://wiki.openwrt.org/HardwarePerformance"
LICENSE = "GPL"
SECTION = "devel"

SRC_URI = "file://openwrt_cpu_bench_v06.c"

do_compile() {
	${CC} -O0 ${LDFLAGS} ${WORKDIR}/openwrt_cpu_bench_v06.c -o cpubench
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 cpubench ${D}${bindir}
}
