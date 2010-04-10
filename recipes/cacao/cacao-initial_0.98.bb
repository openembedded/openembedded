require cacao-native.inc

PROVIDES = "virtual/java-initial"

DEPENDS = "zlib-native libtool-native fastjar-native classpath-initial jikes-initial"

PR = "r0"

SRC_URI = "\
        http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-${PV}/cacao-${PV}.tar.bz2; \
        file://cacao-0.98-initial.patch;patch=1;pnum=1 \
        "

# libjvm disabled - it would conflict with cacao-native installations
EXTRA_OECONF = "\
    --enable-debug \
    --with-classpath-libdir=${libdir} \
    --with-classpath-includedir=${includedir}/classpath-initial \
    --with-classpath-classes=${datadir}/classpath-initial/glibj.zip \
    --with-vm-zip=${datadir}/cacao-initial/vm.zip \
    --program-suffix=-initial \
    --disable-libjvm \
    "

# enforces the usage of jikes-initial
export JAVAC=jikes-initial

# enforces the usage of fastjar
export JAR=fastjar

do_configure_append() {
  # Fix the executable name in the wrapper script.
  sed -i -e "s|exec cacao|exec cacao-initial|" src/scripts/java.in
}

SRC_URI[md5sum] = "8b8907c8b925761c9410bcadb9705346"
SRC_URI[sha256sum] = "cb9363add825cedf77764fc49a223aaf43f0a9f485b711ba8c92f16b13fff188"
