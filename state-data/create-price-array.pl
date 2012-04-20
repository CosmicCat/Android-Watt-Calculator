#!/usr/bin/perl
use strict;

use Postal::US::State;
use Text::CSV_XS;

my $filename = 'energy-prices.csv';

my $csv = Text::CSV_XS->new();
open my $fh, "<$filename" or die "Couldn't open $filename";

while (my $row = $csv->getline($fh)) {
    next unless $row->[0];
    my $code = Postal::US::State->code($row->[0]);
    next unless $code;
    print qq/"$code", "$row->[2]",\n/;
}
