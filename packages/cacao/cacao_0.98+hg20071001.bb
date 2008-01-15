require cacao.inc

PR = "r5"

SRC_URI = "\
        http://jalimo.evolvis.org/repository/sources/cacao-${PV}.tar.bz2;md5sum=9ff10c929bd0cbf15909107c1aff7518 \
        file://cacao-0.98+svn-libdir.diff;patch=1 \
        file://cacao-0.98+svn-classpath_var.patch;patch=1 \
        file://cacao-0.98+hg-arm-cacheflush-workaround.patch;patch=1 \
        file://cacao-0.98+hg-attachthread.patch;patch=1 \
        "

EXTRA_OECONF += "\
    --enable-annotations \
		"

