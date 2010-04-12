require shared-mime-info.inc

PR = "r1"

pkg_postinst () {
if [ "x$D" != "x" ]; then
        exit 1
fi
  echo "Updating MIME database... this may take a while."
  ${bindir}/update-mime-database ${datadir}/mime
}

SRC_URI[md5sum] = "62184241d497d34138285bc248b3fabc"
SRC_URI[sha256sum] = "6febe616fb850f4319efa7017312abb796024e7ac20da37c4d2ce34afa41776c"
