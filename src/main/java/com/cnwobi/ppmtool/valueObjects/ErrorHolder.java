package com.cnwobi.ppmtool.valueObjects;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorHolder {
  private Instant timeStamp;
  private String message;
  private String details;

}
