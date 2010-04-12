require shared-mime-info.inc

PR = "r2"

pkg_postinst () {
if [ "x$D" != "x" ]; then
        exit 1
fi
  echo "Updating MIME database... this may take a while."
  ${bindir}/update-mime-database ${datadir}/mime
}

SRC_URI[md5sum] = "b3b4b45ef3f76f720fd0c389f131dd4c"
SRC_URI[sha256sum] = "d933caa25caacd57dc8b37f68d222acec3ba3c9d076828d34f006499f6301fb2"
