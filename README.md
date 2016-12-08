# CPU Scheduling Algorithms RR and MLFQ
I was trying to compare the two CPU scheduling algoritmns
Round Robin and Multi Level Feedback Queue

The fundamental problem MLFQ tries to address is two-fold. First, it
would like to optimize turnaround time, which may be obtained by running shorter jobs first;
unfortunately, the OS doesn’t generally know how long a job will run for, exactly the knowledge that
algorithms like SJF (or STCF) require. Second, MLFQ would like to make
a system feel responsive to interactive users (i.e., users sitting and staring
at the screen, waiting for a process to finish), and thus minimize response
time; Round Robin algorithm would reduce response time
but are terrible for turnaround time

According to the  priority boost back time of the MLFQ. The average turn around time is always better in MLFQ
the outputs(are in the file outputs.txt) for the given inputs(are in the file input.txt) are compared and shown in the graphs attached.
