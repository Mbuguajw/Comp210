"""CSV demo."""

import csv
from typing import List, Dict


def csv(path: str) -> List[Dict[str, str]]:
    """Read a CSV TO A LIST OF ROWS (REPRESENTED AS dICTS)"""
    file = open(path, 'r', encoding="utf-8")
    reader = csv.DictReader(file)
    row: List[Dict[str, str]] = []
    for row in reader:
        rows.append(row)
    file.close()
    return rows