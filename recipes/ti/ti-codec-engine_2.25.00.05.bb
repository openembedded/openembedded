require ti-codec-engine.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_omapl138 = "1"


# tconf from xdctools dislikes '.' in pwd :/
PV = "2_25_00_05"

SRC_URI[cetarball.md5sum] = "729ede0fd24210d3c5439511fa859d51"
SRC_URI[cetarball.sha256sum] = "81f815159f3dfda0525be6da543644b02c3610bcb080df170cbd27e2d8420ba2"

do_install_prepend() {
    ln -sf  ${S}/examples/apps/system_files/OMAPL137  ${S}/examples/apps/system_files/OMAPL138 || true
}
