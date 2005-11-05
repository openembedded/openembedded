#!/usr/bin/perl

my $pat = shift(@ARGV) || usage(1);
my $infile = shift(@ARGV) || usage(1);
my $outfile = shift(@ARGV) || "-";
print STDERR "Package-strip processing input file $infile\n";
print STDERR "Output to " . ($outfile ne "-" ? $outfile : "stdout") . "\n";

# massage the regexp to accept semi-shell-style *
$pat =~ s/\*/.*/g;

open (I,"<$infile") || die $@;
open (O,">>$outfile") || die $@;
undef $/;
my $srctext = <I>;
close(I);

my @srclist = split(/\012\012\012/,$srctext);
my @outlist = grep(/Package: $pat/,@srclist);
print O join("\012\012\012",@outlist);
print O "\012\012\012";

sub usage {
       my $cack = shift(@_);
       print STDERR "usage: Package-strip <regexp> <filename> [output filename]\nRemember to escape wildcard characters for the shell.";
       die if $cack;
}

