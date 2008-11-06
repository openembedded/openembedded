require shared-mime-info.inc

PR = "r2"

pkg_postinst () {
if [ "x$D" != "x" ]; then
        exit 1
fi
  echo "Updating MIME database... this may take a while."
  ${bindir}/update-mime-database ${datadir}/mime
}
