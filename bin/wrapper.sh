path_remove () {
    echo $PATH | tr ':' '\n' | grep -v "^$1\$" | tr '\n' ':'
}

PATH="$(path_remove $(dirname $0))"

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
    exec "$(basename $0)" "$@"
}
