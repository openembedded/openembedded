path_remove () {
    echo $PATH | tr ':' '\n' | grep -v "^$1\$" | tr '\n' ':'
}

quote(){
    sed -e "s,','\\\\'',g; 1s,^,',; \$s,\$,',;" << EOF
$1
EOF
}

save () {
    case "$1" in
    # when a string contains a "'" we have to escape it
    *\'*)
        saved="$saved $(quote "$1")"
        ;;
    # otherwise just quote the variable
    *)
        saved="$saved '$1'"
        ;;
    esac
}

exec_real () {
    eval set -- "$saved"
    scriptdir="$(dirname $0)"
    PATH="$(path_remove $scriptdir)"
    exec "$(basename $0)" "$@"
}
